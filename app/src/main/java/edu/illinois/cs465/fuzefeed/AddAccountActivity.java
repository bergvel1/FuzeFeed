package edu.illinois.cs465.fuzefeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class AddAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        String [] names = new String [3];
        names[0]="Facebook";
        names[1]="Instagram";
        names[2]="Twitter";

        Spinner mySpinner = (Spinner)findViewById(R.id.populate_account);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner,R.id.view,names);
        mySpinner.setAdapter(adapter);

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        Button addButton = (Button) findViewById(R.id.add_button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
