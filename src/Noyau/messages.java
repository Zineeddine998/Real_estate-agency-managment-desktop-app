package Noyau;

public class messages {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;


    public messages (String username, String message){
        this.message = message;
        this.username = username;
    }
}
