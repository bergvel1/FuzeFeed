package edu.illinois.cs465.fuzefeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by karth on 11/14/2016.
 */

public class PlatformList extends Activity {
    Button continueButton;
    Button cancelPostButton;
    PostPlatform[] platforms = {new PostPlatform("Facebook"), new PostPlatform("Twitter"), new PostPlatform("Instagram"), new PostPlatform("Reddit")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform_list);
        PlatformAdapter adapter = new PlatformAdapter(this,platforms);

        ListView listView = (ListView) findViewById(R.id.platform_list);
        listView.setAdapter(adapter);
        continueButton = (Button) findViewById(R.id.continueButton);
        cancelPostButton = (Button) findViewById(R.id.cancelPostButton);
        final Context context = this;
        continueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, CreateContent.class);
                startActivity(intent);
            }
        });

        cancelPostButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                finish();
            }
        });
    }
}
