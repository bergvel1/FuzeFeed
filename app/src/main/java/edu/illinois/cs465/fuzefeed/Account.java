package edu.illinois.cs465.fuzefeed;

/**
 * Created by BrianKurek on 11/15/16.
 */

public class Account {
    private Platform platform;
    private String username;
    private boolean isActive;

    public Account(Platform platform, String username, boolean isActive) {
        this.platform = platform;
        this.username = username;
        this.isActive = isActive;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getUsername() {
        return username;
    }

    public boolean getStatus(){
        return isActive;
    }

    public void setStatus(boolean status){
        this.isActive = status;
    }
}
