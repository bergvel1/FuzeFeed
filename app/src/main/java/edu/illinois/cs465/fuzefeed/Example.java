package edu.illinois.cs465.fuzefeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Example extends AppCompatActivity {

    private TextView username;
    private TextView timestamp;
    private ImageView profilePicture;
    private ImageView image;
    private DataCreator dc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        username = (TextView) findViewById(R.id.username);
        timestamp = (TextView) findViewById(R.id.timestamp);
        profilePicture = (ImageView) findViewById(R.id.profile_picture);
        image = (ImageView) findViewById(R.id.post_image);
        dc = new DataCreator(this);

        List<Post> posts = dc.getInstagramPosts();

        username.setText(posts.get(0).getUsername());
        timestamp.setText(posts.get(0).getTimestamp().toString());
        profilePicture.setImageBitmap(posts.get(0).getProfilePicture());
        image.setImageBitmap(posts.get(0).getImage());

    }
}
