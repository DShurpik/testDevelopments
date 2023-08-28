package api.reqresin;

public class UnsucessfulRegistr {
    private String error;

    public UnsucessfulRegistr(String error) {
        this.error = error;
    }

    public UnsucessfulRegistr() {

    }

    public String getError() {
        return error;
    }
}
