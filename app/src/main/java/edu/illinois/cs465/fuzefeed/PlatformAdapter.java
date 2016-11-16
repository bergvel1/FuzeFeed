package edu.illinois.cs465.fuzefeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

/**
 * Created by karth on 11/15/2016.
 */
public class PlatformAdapter extends ArrayAdapter<PostPlatform>{
    PostPlatform[] platforms = null;
    Context context;
    public PlatformAdapter(Context context, PostPlatform[] arr) {
        super(context,R.layout.activity_platformview,arr);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.platforms = arr;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.activity_platformview, parent, false);
        CheckedTextView c = (CheckedTextView) convertView.findViewById(R.id.platform);
        c.setText(platforms[position].getName());
        c.setOnClickListener((new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ((CheckedTextView) arg0).toggle();
            }

        }));

        return convertView;
    }
}
