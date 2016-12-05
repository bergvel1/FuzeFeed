package edu.illinois.cs465.fuzefeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

public class AddAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        // determine which to which category the account should be added
        Bundle extras = getIntent().getExtras();
        final int feedID = extras.getInt("FEED_ID"); // null pointer danger here!

        TextView addAccountHeader = (TextView) findViewById(R.id.add_account_header);
        if(feedID == 0) addAccountHeader.setText("Add Existing Social Account");
        if(feedID == 1) addAccountHeader.setText("Add Existing Professional Account");
        if(feedID == 2){
            addAccountHeader.setText("Add Existing Email Account");
            LinearLayout platformRow = (LinearLayout) findViewById(R.id.platform_row);
            platformRow.setVisibility(LinearLayout.INVISIBLE);
        }

        String [] names = new String [4];
        names[0]="Facebook";
        names[1]="Instagram";
        names[2]="Twitter";
        names[3]="LinkedIn";

        final Spinner mySpinner = (Spinner)findViewById(R.id.populate_account);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner,R.id.view,names);
        mySpinner.setAdapter(adapter);

        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        Button addButton = (Button) findViewById(R.id.add_button);

        final EditText usernameField = (EditText) findViewById(R.id.username_field);
        //EditText passwordField = (EditText) findViewById(R.id.password_field); // placeholder

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account newAccount;
                if(feedID == 2) newAccount = new Account(Platform.Email,
                        usernameField.getText().toString(),true);
                else newAccount = new Account(Platform.valueOf(mySpinner.getSelectedItem().toString()),
                        usernameField.getText().toString(),true);
                MainActivity.addAccount(feedID,newAccount);
                finish();
            }
        });

    }


}
