package edu.illinois.cs465.fuzefeed;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by BrianKurek on 11/13/16.
 */

public final class DataCreator {

    private Context context;
    private List<Post> facebookPosts;
    private List<Post> twitterPosts;
    private List<Post> instagramPosts;
    private List<Post> linkedinPosts;
    private List<Post> socialPosts;
    private List<Post> emails;
    private List<Account> accounts;

    public DataCreator(Context context) {
        this.context = context;

        facebookPosts = new ArrayList<>();

        getFacebookPosts().add(new Post(Platform.Facebook,
                "Brian Kurek",
                new Date(1476381531000L),
                "This is an example Facebook post for FuzeFeed!",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getFacebookPosts().add(new Post(Platform.Facebook,
                "David Bergvelt",
                new Date(1478368731000L),
                "Wow this new FuzeFeed app is amazing. I recommend everyone download it and give it a shot.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getFacebookPosts().add(new Post(Platform.Facebook,
                "Karthik Bala",
                new Date(1477936731000L),
                "I can't believe its Halloween already. I can't wait for fall break.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        twitterPosts = new ArrayList<>();

        getTwitterPosts().add(new Post(Platform.Twitter,
                "Deekshant Kaul",
                new Date(1478541531000L),
                "Seriously guys, this app NEEDS to suppport email",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getTwitterPosts().add(new Post(Platform.Twitter,
                "Pallavi Srivastava",
                new Date(1479059931000L),
                "Guys it's almost fall break. I need this week off.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getTwitterPosts().add(new Post(Platform.Twitter,
                "Karthik Bala",
                new Date(1477936731000L),
                "Just in case you didn't see my Facebook post, it's Halloween.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        instagramPosts = new ArrayList<>();

        getInstagramPosts().add(new Post(Platform.Instagram,
                "Brian Kurek",
                new Date(1476381531000L),
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.iphone),
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getInstagramPosts().add(new Post(Platform.Instagram,
                "David Bergvelt",
                new Date(1479059931000L),
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.flower),
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getInstagramPosts().add(new Post(Platform.Instagram,
                "Deekshant Kaul",
                new Date(1476381531000L),
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.road),
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        linkedinPosts = new ArrayList<>();

        getLinkedinPosts().add(new Post(Platform.LinkedIn,
                "Deekshant Kaul",
                new Date(1478541531000L),
                "Check out this cool article about working at Microsoft.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getLinkedinPosts().add(new Post(Platform.LinkedIn,
                "Pallavi Srivastava",
                new Date(1479059931000L),
                "Here's one of my favorite articles about interview tips!",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        getLinkedinPosts().add(new Post(Platform.LinkedIn,
                "Karthik Bala",
                new Date(1477936731000L),
                "Another example LinkedIn post.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        emails = new ArrayList<>();

        getEmails().add(new Post("Brian Kurek",
                "Example subject",
                "This is an example email.",
                new Date(1477936731000L),
                "Gmail",
                Platform.Email));

        getEmails().add(new Post("David Bervelt",
                "Another email",
                "Yet another example of an email.",
                new Date(1479059931000L),
                "Gmail",
                Platform.Email));

        getEmails().add(new Post("Deekshant Kaul",
                "We did it",
                "Guys look, we actually support viewing emails.",
                new Date(1479059931000L),
                "Hotmail",
                Platform.Email));

        getEmails().add(new Post("Brian Kurek",
                "Example subject",
                "This is an example email.",
                new Date(1477936731000L),
                "Gmail",
                Platform.Email));

        getEmails().add(new Post("David Bervelt",
                "Another email",
                "Yet another example of an email.",
                new Date(1479059931000L),
                "Gmail",
                Platform.Email));

        getEmails().add(new Post("Deekshant Kaul",
                "We did it",
                "Guys look, we actually support viewing emails.",
                new Date(1479059931000L),
                "Hotmail",
                Platform.Email));

        getEmails().add(new Post("Brian Kurek",
                "Example subject",
                "This is an example email.",
                new Date(1477936731000L),
                "Gmail",
                Platform.Email));

        getEmails().add(new Post("David Bervelt",
                "Another email",
                "Yet another example of an email.",
                new Date(1479059931000L),
                "Gmail",
                Platform.Email));

        getEmails().add(new Post("Deekshant Kaul",
                "We did it",
                "Guys look, we actually support viewing emails.",
                new Date(1479059931000L),
                "Hotmail",
                Platform.Email));

        socialPosts = new ArrayList<>();
        getSocialPosts().addAll(facebookPosts);
        getSocialPosts().addAll(twitterPosts);
        getSocialPosts().addAll(instagramPosts);

        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Post> getSocialPosts() {
        return socialPosts;
    }

    public List<Post> getFacebookPosts() {
        return facebookPosts;
    }

    public List<Post> getTwitterPosts() {
        return twitterPosts;
    }

    public List<Post> getInstagramPosts() {
        return instagramPosts;
    }

    public List<Post> getLinkedinPosts() {
        return linkedinPosts;
    }

    public List<Post> getEmails() {
        return emails;
    }

    public void addPost(Platform platform, Post p) {
        switch(platform) {
            case Facebook:
                facebookPosts.add(p);
                break;
            case Twitter:
                twitterPosts.add(p);
                break;
            case Instagram:
                instagramPosts.add(p);
                break;
            case LinkedIn:
                linkedinPosts.add(p);
                break;
        }

        socialPosts.add(p);
    }

    public void addEmail(Post e) {
        emails.add(e);
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }
}
