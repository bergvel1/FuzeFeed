package edu.illinois.cs465.fuzefeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by karth on 11/14/2016.
 */

public class PlatformList extends Activity {
    Button postButton;
    Button backToCreateContent;
    PostPlatform[] platforms = {new PostPlatform("Facebook"), new PostPlatform("Twitter"), new PostPlatform("Instagram"), new PostPlatform("Reddit")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform_list);
        PlatformAdapter adapter = new PlatformAdapter(this,platforms);

        ListView listView = (ListView) findViewById(R.id.platform_list);
        listView.setAdapter(adapter);
        postButton = (Button) findViewById(R.id.postButton);
        backToCreateContent = (Button) findViewById(R.id.backToCreateContent);
        final Context context = this;
        postButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Toast toast = Toast.makeText(context, "Posted!", Toast.LENGTH_SHORT);
                toast.show();

                //go back to create post
                finish();
            }
        });

        backToCreateContent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(context, CreateContent.class);
                startActivity(intent);
            }
        });
    }
}
