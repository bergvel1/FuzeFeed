package edu.illinois.cs465.fuzefeed;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.facebook_item, null);
                    // get data fields
                    TextView username = (TextView) convertView.findViewById(R.id.username);
                    TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);
                    TextView content = (TextView) convertView.findViewById(R.id.content);
                    ImageView image = (ImageView) convertView.findViewById(R.id.post_image);
                    // populate
                    username.setText(item.getUsername());
                    timestamp.setText(item.getTimestamp().toString());
                    content.setText(item.getContent());
                    image.setVisibility(View.GONE);
                }

                return convertView;
            }
            case TWITTER: {
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.twitter_item, null);
                    // get data fields
                    TextView username = (TextView) convertView.findViewById(R.id.username);
                    TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);
                    TextView content = (TextView) convertView.findViewById(R.id.content);
                    ImageView image = (ImageView) convertView.findViewById(R.id.post_image);
                    // populate
                    username.setText(item.getUsername());
                    timestamp.setText(item.getTimestamp().toString());
                    content.setText(item.getContent());
                    image.setVisibility(View.GONE);
                }

                return convertView;
            }
            case INSTAGRAM: {
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.instagram_item, null);
                    // get data fields
                    TextView username = (TextView) convertView.findViewById(R.id.username);
                    TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);
                    ImageView image = (ImageView) convertView.findViewById(R.id.post_image);
                    // populate
                    username.setText(item.getUsername());
                    timestamp.setText(item.getTimestamp().toString());
                    image.setImageBitmap(item.getImage());
                }

                return convertView;
            }
            case LINKEDIN: {
                if (convertView == null)
                    convertView = inflater.inflate(R.layout.feed_item, null);
                return convertView;
            }
            case EMAIL: {
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.email_item, null);
                    // get data fields
                    TextView sender = (TextView) convertView.findViewById(R.id.sender);
                    TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);
                    TextView preview = (TextView) convertView.findViewById(R.id.preview);
                    TextView service = (TextView) convertView.findViewById(R.id.service);
                    TextView subject = (TextView) convertView.findViewById(R.id.subject);
                    // populate
                    sender.setText(item.getSender());
                    timestamp.setText(item.getTimestamp().toString());
                    preview.setText(item.getPreview());
                    service.setText(item.getEmailPlatform());
                    subject.setText(item.getSubject());
                }

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

