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
    Button selectPlatformButton;
    Button backToHomeButton;

    public void addListenerOnButton() {

        final Context context = this;

        selectPlatformButton = (Button) findViewById(R.id.selectPlatformButton);
        backToHomeButton = (Button) findViewById(R.id.backToHomeButton);

        selectPlatformButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, PlatformList.class);
                startActivity(intent);

            }

        });
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
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
