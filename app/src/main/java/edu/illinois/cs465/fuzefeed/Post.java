package edu.illinois.cs465.fuzefeed;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by BrianKurek on 11/13/16.
 */

public class Post {
    private Platform platform;
    private String username;
    private Date timestamp;
    private String content; // null if there isn't text content
    private Bitmap image; // null if there isn't an image
    private Bitmap profilePicture;

    public Post (){
        /*nothing*/
    }

    // for testing
    public Post(String content){
        this.content = content;
    }

    public Post(Platform platform, String username, Date timestamp, String content, Bitmap image, Bitmap profilePicture) {
        this.platform = platform;
        this.username = username;
        this.timestamp = timestamp;
        this.content = content;
        this.image = image;
        this.profilePicture = profilePicture;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getUsername() {
        return username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public Bitmap getImage() {
        return image;
    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }
}
