package api.reqresin;

public class RegistrarionRequest {

    private String email;
    private String password;

    public RegistrarionRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegistrarionRequest() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
