import models.CreateUserBuilder;
import models.CreateUserBuilderLombok;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestNGLogginExtension;

@Listeners(TestNGLogginExtension.class)
public class BuilderTests {

    @Test
    public void test1() {
        CreateUserBuilder createUserBuilder = new CreateUserBuilder
                .Builder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("Johndoe@gmail.com")
                .withCheckbox(false)
                .withPassword("password")
                .build();

        System.out.println(createUserBuilder.toString());
    }

    @Parameters({"firstname", "lastname", "email", "password", "checkbox"})
    @Test
    public void test2(String firstname, String lastname, String email, String password, Boolean checkbox) {
        CreateUserBuilderLombok user = CreateUserBuilderLombok
                .builder()
                .firstName(firstname)
                .lastName(lastname)
                .email(email)
                .password(password)
                .checkbox(checkbox)
                .build();

        System.out.println(user);
    }


    /** If values are present in the xml file, they will be applied in the fields.
     * If values aren't present in the xml file, values from @Optional will be applied in the fields*/

    @Parameters({"firstname", "lastname", "email", "password", "checkbox"})
    @Test
    public void test3(@Optional("DefaultFirstName") String firstname,
                      @Optional("DefaultLastName")String lastname,
                      @Optional("DefaultEmail")String email,
                      @Optional("DefaultPassword")String password,
                      @Optional("true")Boolean checkbox) {
        CreateUserBuilderLombok user = CreateUserBuilderLombok
                .builder()
                .firstName(firstname)
                .lastName(lastname)
                .email(email)
                .password(password)
                .checkbox(checkbox)
                .build();

        System.out.println(user);
    }
}
