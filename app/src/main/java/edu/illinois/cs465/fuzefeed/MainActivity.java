package edu.illinois.cs465.fuzefeed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    // stuff for hamburger menu
    private DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;

    // feed selectors
    private Button socialSelector;
    private Button proSelector;
    private Button emailSelector;

    // stuff for feed
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<Post> feedItems;

    // this is not ideal
    private int currAdapter;

    private FeedListAdapter socialListAdapter; // currAdapter -> 0
    private List<Post> socialFeedItems;

    private FeedListAdapter proListAdapter; // currAdapter -> 1
    private List<Post> proFeedItems;

    private FeedListAdapter emailListAdapter; // currAdapter -> 2
    private List<Post> emailFeedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup button for adding posts
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currAdapter == 0){
                    Post newItem = new Post("IT'S A BRAND NEW SOCIAL POST");
                    socialFeedItems.add(0,newItem);
                    socialListAdapter.notifyDataSetChanged();
                }
                if(currAdapter == 1){
                    Post newItem = new Post("NEW BUSINESS IS HAPPENING");
                    proFeedItems.add(0,newItem);
                    proListAdapter.notifyDataSetChanged();
                }
                if(currAdapter == 2){
                    Post newItem = new Post("NEW EMAIL");
                    emailFeedItems.add(0,newItem);
                    emailListAdapter.notifyDataSetChanged();
                }
            }
        });

        // toolbar and hamburger menu setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        /* to set the menu icon image*/
        ab.setHomeAsUpIndicator(R.mipmap.ic_list_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        // setting list adapter
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Log.d("DEBUG", "submenu item clicked");
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Log.d("DEBUG", "heading clicked");
                return false;
            }
        });

        // buttons to choose between feeds
        socialSelector = (Button) findViewById(R.id.social_selector);
        proSelector = (Button) findViewById(R.id.pro_selector);
        emailSelector = (Button) findViewById(R.id.email_selector);

        // set up listeners
        socialSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(socialListAdapter);
                currAdapter = 0;
            }
        });
        proSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(proListAdapter);
                currAdapter = 1;
            }
        });
        emailSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(emailListAdapter);
                currAdapter = 2;
            }
        });


        // feed stuff
        listView = (ListView) findViewById(R.id.list);

        socialFeedItems = new ArrayList<Post>();
        proFeedItems = new ArrayList<Post>();
        emailFeedItems = new ArrayList<Post>();

        socialListAdapter = new FeedListAdapter(this, socialFeedItems);
        proListAdapter = new FeedListAdapter(this, proFeedItems);
        emailListAdapter = new FeedListAdapter(this, emailFeedItems);

        // default starting view has social feed displayed
        listView.setAdapter(socialListAdapter);
        currAdapter = 0;

        // some placeholder posts
        Post socialItem1 = new Post("here's a social post");
        Post proItem1 = new Post("business");
        Post emailItem1 = new Post("here's an email");
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        socialFeedItems.add(socialItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        proFeedItems.add(proItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);
        emailFeedItems.add(emailItem1);

        socialListAdapter.notifyDataSetChanged();
        proListAdapter.notifyDataSetChanged();
        emailListAdapter.notifyDataSetChanged();
    }
    
    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("Social");
        // Adding data header
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("Professional");
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("Email");
        listDataHeader.add(item3);

        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Submenu of item 1");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("Submenu of item 2");
        heading2.add("Submenu of item 2");
        heading2.add("Submenu of item 2");

        listDataChild.put(listDataHeader.get(0), heading1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), heading2);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {

        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
}
