import api.reqresin.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import listeners.ListenerForAPI;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Listeners(ListenerForAPI.class)

public class ReqresInApiTests {

    private static final String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> usersList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/reqresin/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("data", UserData.class);

        /** Check that all users id are equal to users avatar **/
        usersList.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        /** Email finish with @reqres.in **/
        Assert.assertTrue(usersList.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = usersList.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = usersList.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        List<String> emails = usersList.stream().map(UserData::getEmail).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(emails.get(i).contains("@reqres.in"));
        }
    }

    @Test
    public void checkAvatarAndIdTest2(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecification200());

        List<UserData> usersList = given()
                .when()
                .get("api/reqresin/users?page=2")
                .then()
                .log().all()
                .extract()
                .body().jsonPath().getList("data", UserData.class);

        /** Check that all users id are equal to users avatar **/
        usersList.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        /** Email finish with @reqres.in **/
        Assert.assertTrue(usersList.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = usersList.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = usersList.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        List<String> emails = usersList.stream().map(UserData::getEmail).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(emails.get(i).contains("@reqres.in"));
        }
    }

    @Test
    public void successRegistrationTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecification200());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        RegistrarionRequest request = new RegistrarionRequest("eve.holt@reqres.in", "pistol");

        RegistrationResponse response = given()
                .body(request)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(RegistrationResponse.class);

        /** Check that response isn't empty **/
        Assert.assertNotNull(response.getId());
        Assert.assertNotNull(response.getToken());

        Assert.assertEquals(id, response.getId());
        Assert.assertEquals(token, response.getToken());
    }

    @Test
    public void failRegistrationTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification400());

        RegistrarionRequest request = new RegistrarionRequest("eve.holt@reqres.in", "");

        UnsucessfulRegistr response = given()
                .body(request)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsucessfulRegistr.class);

        Assert.assertEquals(response.getError(), "Missing password");
    }

    @Test
    public void checkSortDataTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification200());

        List<ColorsData> colorsList = given()
                .when()
                .get("/api/unknown")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);

        List<Integer> ages = colorsList.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedAges = ages.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(ages, sortedAges);
    }

    @Test
    public void deleteUserTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification(204));

        given()
                .when()
                .delete("/api/users/2")
                .then()
                .log().all();
    }

    /** API Tests without using POJO classes **/

    @Test
    public void checkAvatarAndIdTestWithoutPOJO(){

        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification200());

        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .body("data.avatar", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.email", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        List<String> email = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        List<String> avatars = jsonPath.get("data.avatar");
        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }

        /** allMatch that each value must be accepted **/

        Assert.assertTrue(email.stream().allMatch(x -> x.endsWith("@reqres.in")));
        }

    @Test
    public void successRegistrationWithoutPOJOTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification200());

        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("id", equalTo(id))
                .body("token", equalTo(token));
    }

    @Test
    public void successRegistrationWithoutPOJOTest1(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification200());

        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        int idRes = jsonPath.get("id");
        String tokenRes = jsonPath.get("token");

        Assert.assertEquals(idRes, id);
        Assert.assertEquals(tokenRes, token);
    }

    @Test
    public void failRegistrationWithoutPOJOTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification400());

        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");

        given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("error", equalTo("Missing password"));

    }

    @Test
    public void failRegistrationWithoutPOJOTest1(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL),
                Specifications.responseSpecification400());

        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");

        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("error");

        Assert.assertEquals(error, "Missing password");
    }

}
