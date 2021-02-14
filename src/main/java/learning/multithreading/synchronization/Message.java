package learning.multithreading.synchronization;

public class Message {
    private String message;

    public Message(String string){
        this.message = string;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String string) {
        this.message = string;
    }

}