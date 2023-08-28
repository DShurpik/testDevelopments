package api.reqresin;

public class RegistrationResponse {

    public Integer id;
    public String token;

    public RegistrationResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public RegistrationResponse() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
