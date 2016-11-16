package edu.illinois.cs465.fuzefeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by karth on 11/15/2016.
 */
public class CreateContent extends Activity {
    Button postButton;
    Button backButton;

    public void addListenerOnButton() {

        final Context context = this;

        postButton = (Button) findViewById(R.id.postButton);
        backButton = (Button) findViewById(R.id.backButton);

        postButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_content);
        addListenerOnButton();
    }
}
