package edu.illinois.cs465.fuzefeed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by BrianKurek on 11/13/16.
 */

public final class DataCreator {

    private Context context;

    public DataCreator(Context context) {
        this.context = context;
    }

    public List<Post> getFacebookPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(Platform.FACEBOOK,
                "Brian Kurek",
                new Date(1476381531000L),
                "This is an example Facebook post for FuzeFeed!",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.FACEBOOK,
                "David Bergvelt",
                new Date(1478368731000L),
                "Wow this new FuzeFeed app is amazing. I recommend everyone download it and give it a shot.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.FACEBOOK,
                "Karthik Bala",
                new Date(1477936731000L),
                "I can't believe its Halloween already. I can't wait for fall break.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        return posts;
    }

    public List<Post> getTwitterPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(Platform.TWITTER,
                "Deekshant Kaul",
                new Date(1478541531000L),
                "Seriously guys, this app NEEDS to suppport email",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.TWITTER,
                "Pallavi Srivastava",
                new Date(1479059931000L),
                "Guys it's almost fall break. I need this week off.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.TWITTER,
                "Karthik Bala",
                new Date(1477936731000L),
                "Just in case you didn't see my Facebook post, it's Halloween.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        return posts;
    }

    public List<Post> getInstagramPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(Platform.INSTAGRAM,
                "Brian Kurek",
                new Date(1476381531000L),
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.iphone),
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.INSTAGRAM,
                "David Bergvelt",
                new Date(1479059931000L),
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.flower),
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.INSTAGRAM,
                "Deekshant Kaul",
                new Date(1476381531000L),
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.road),
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        return posts;
    }

    public List<Post> getLinkedInPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(Platform.LINKEDIN,
                "Deekshant Kaul",
                new Date(1478541531000L),
                "Check out this cool article about working at Microsoft.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.LINKEDIN,
                "Pallavi Srivastava",
                new Date(1479059931000L),
                "Here's one of my favorite articles about interview tips!",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        posts.add(new Post(Platform.LINKEDIN,
                "Karthik Bala",
                new Date(1477936731000L),
                "Another example LinkedIn post.",
                null,
                BitmapFactory.decodeResource(context.getResources(), R.raw.placeholder)));

        return posts;
    }

    public List<Email> getEmails() {
        ArrayList<Email> emails = new ArrayList<>();

        emails.add(new Email("Brian Kurek",
                "Example subject",
                "This is an example email.",
                new Date(1477936731000L),
                "Gmail"));

        emails.add(new Email("David Bervelt",
                "Another email",
                "Yet another example of an email.",
                new Date(1479059931000L),
                "Gmail"));

        emails.add(new Email("Deekshant Kaul",
                "We did it",
                "Guys look, we actually support viewing emails.",
                new Date(1479059931000L),
                "Hotmail"));

        return emails;
    }
}
