package crud.projeto.master.dto;

public class FildMessage {
    private String fild;
    private String message;

    public FildMessage() {
    }

    public FildMessage(String fild, String message) {
        this.fild = fild;
        this.message = message;
    }

    public String getFild() {
        return fild;
    }

    public void setFild(String fild) {
        this.fild = fild;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
