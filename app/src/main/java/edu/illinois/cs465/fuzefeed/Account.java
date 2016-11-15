package edu.illinois.cs465.fuzefeed;

/**
 * Created by BrianKurek on 11/15/16.
 */

public class Account {
    private Platform platform;
    private String username;

    public Account(Platform platform, String username) {
        this.platform = platform;
        this.username = username;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getUsername() {
        return username;
    }
}
