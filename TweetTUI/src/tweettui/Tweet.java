<<<<<<< HEAD
package tweettui;

public class Tweet {

    private String msg;
    private String owner;
    private String date;

    public Tweet() {
    }

    public Tweet(String msg) {
        this.msg = msg;
    }

    public Tweet(String msg, String owner, String date) {
        this.msg = msg;
        this.owner = owner;
        this.date = date;
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

    public String getDate() {
        return date;
    }

}
=======
package tweettui;

public class Tweet {

    private String msg;
    private String owner;
    private String date;

    public Tweet() {
    }

    public Tweet(String msg) {
        this.msg = msg;
    }

    public Tweet(String msg, String owner, String date) {
        this.msg = msg;
        this.owner = owner;
        this.date = date;
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

    public String getDate() {
        return date;
    }

}
>>>>>>> origin/master
