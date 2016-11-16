package edu.illinois.cs465.fuzefeed;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dbergv on 11/14/16.
 */

public class FeedListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Post> feedItems;

    public FeedListAdapter(Activity activity, List<Post> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Post item = feedItems.get(position);

        switch (item.getPlatform()){
            case FACEBOOK: {
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.facebook_item, null);
                // populate data fields
                return convertView;
            }
            case TWITTER: {
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.twitter_item, null);
                // populate data fields
                return convertView;
            }
            case INSTAGRAM: {
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.instagram_item, null);
                // populate data fields
                return convertView;
            }
            case LINKEDIN: {
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.feed_item, null);
                return convertView;
            }
            case EMAIL: {
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.email_item, null);
                // populate data fields
                return convertView;
            }
        }


        /*TextView placeholder = (TextView) convertView.findViewById(R.id.placeholder);

        placeholder.setText(item.getContent());*/

        // shouldn't be reached
        if (convertView == null)
            convertView = inflater.inflate(R.layout.feed_item, null);
        return convertView;
    }
}

