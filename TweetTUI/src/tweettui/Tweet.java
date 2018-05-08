package tweettui;

public class Tweet {

    private String msg;
    private String owner;

    public Tweet() {
        this.msg = null;
        this.owner = null;
    }

    public Tweet(String msg, String owner) {
        this.msg = msg;
        this.owner = owner;
    }

    public String getMsg() {
        return msg;
    }

    public String getOwner() {
        return owner;
    }

}
