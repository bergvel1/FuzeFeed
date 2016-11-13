package edu.illinois.cs465.fuzefeed;

import java.util.Date;

/**
 * Created by BrianKurek on 11/13/16.
 */

public class Email {
    private String sender;
    private String subject;
    private String preview;
    private Date timestamp;
    private String platform;

    public Email(String sender, String subject, String preview, Date timestamp, String platform) {
        this.sender = sender;
        this.subject = subject;
        this.preview = preview;
        this.timestamp = timestamp;
        this.platform = platform;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getPreview() {
        return preview;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getPlatform() {
        return platform;
    }
}
