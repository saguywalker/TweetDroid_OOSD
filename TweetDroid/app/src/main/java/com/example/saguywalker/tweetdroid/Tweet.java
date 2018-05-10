package com.example.saguywalker.tweetdroid;

public class Tweet {
    private String owner;
    private String msg;

    public Tweet(){
        this.owner = null;
        this.msg = null;
    }
    public Tweet(String owner, String msg) {
        this.owner = owner;
        this.msg = msg;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
