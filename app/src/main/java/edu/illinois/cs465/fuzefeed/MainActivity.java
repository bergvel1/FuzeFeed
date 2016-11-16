package edu.illinois.cs465.fuzefeed;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    // stuff for hamburger menu
    private DataCreator dc;
    private DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<Account>> listDataChild;

    // feed selectors
    private Button socialSelector;
    private Button proSelector;
    private Button emailSelector;

    // lists of different types of accounts
    private static List<Account> socialAccounts;
    private static List<Account> proAccounts;
    private static List<Account> emailAccounts;

    // stuff for feed
    private ListView listView;

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
        dc = new DataCreator(this);
        preparePostButton();

        // toolbar and hamburger menu setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        /* to set the menu icon image*/
        ab.setHomeAsUpIndicator(R.mipmap.ic_list_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        //expandableList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
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
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                Log.d("DEBUG", "submenu item clicked");

                Account thisAccount = (getAccounts(groupPosition)).get(childPosition);
                thisAccount.setStatus(!(thisAccount.getStatus()));
                mMenuAdapter.notifyDataSetChanged();

                return false; // ???
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Log.d("DEBUG", "heading clicked");
                return false;
            }
        });

        // set up bottom navigation buttons
        prepareFeedSelectors();

        // generate fake feed data
        prepareDummyFeeds();
    }

    private void preparePostButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Context context = this;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlatformList.class);
                startActivity(intent);
            }
        });
    }

    private void prepareFeedSelectors(){
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
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<Account>>();

        socialAccounts = new ArrayList<Account>();
        proAccounts = new ArrayList<Account>();
        emailAccounts = new ArrayList<Account>();

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

        Account facebook = new Account(Platform.FACEBOOK,"example facebook",true);
        Account twitter = new Account(Platform.TWITTER,"example twitter",true);
        socialAccounts.add(facebook);
        socialAccounts.add(twitter);

        Account linkedin = new Account(Platform.LINKEDIN,"example linkedin",true);
        proAccounts.add(linkedin);

        Account email1 = new Account(Platform.EMAIL,"email1",true);
        Account email2 = new Account(Platform.EMAIL,"email2",true);
        emailAccounts.add(email1);
        emailAccounts.add(email2);

        listDataChild.put(listDataHeader.get(0), socialAccounts);// Header, Child data
        listDataChild.put(listDataHeader.get(1), proAccounts);
        listDataChild.put(listDataHeader.get(2), emailAccounts);
    }

    private void prepareDummyFeeds(){
        listView = (ListView) findViewById(R.id.list);

        List<Post> dummyPosts = dc.getSocialPosts();
        List<Post> dummyEmails = dc.getEmails();

        socialFeedItems = new ArrayList<Post>();
        proFeedItems = new ArrayList<Post>();
        emailFeedItems = new ArrayList<Post>();


        socialListAdapter = new FeedListAdapter(this, socialFeedItems);
        proListAdapter = new FeedListAdapter(this, proFeedItems);
        emailListAdapter = new FeedListAdapter(this, emailFeedItems);

        // default starting view has social feed displayed
        listView.setAdapter(socialListAdapter);
        currAdapter = 0;

        for (int i = 0; i < 9; i += 3) {
            socialFeedItems.add(dummyPosts.get(i));
        }

        for (int i = 1; i < 9; i += 3) {
            socialFeedItems.add(dummyPosts.get(i));
        }

        for (int i = 2; i < 9; i += 3) {
            socialFeedItems.add(dummyPosts.get(i));
        }

        for (int i = 0; i < 3; i++) {
            emailFeedItems.add(dummyEmails.get(i));
        }

        socialListAdapter.notifyDataSetChanged();
        proListAdapter.notifyDataSetChanged();
        emailListAdapter.notifyDataSetChanged();
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

        /*//revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });*/
    }

    public static boolean addAccount(int feedID){
        switch (feedID){
            case 0: {
                    Account newAccount = new Account(Platform.FACEBOOK,"new facebook",true);
                    socialAccounts.add(newAccount);
                    return true;
            }
            case 1: {
                    Account newAccount = new Account(Platform.LINKEDIN,"new linkedin",true);
                    proAccounts.add(newAccount);
                    return true;
            }
            case 2: {
                    Account newAccount = new Account(Platform.EMAIL,"new email",true);
                    emailAccounts.add(newAccount);
                    return true;
            }
        }
        Log.d("DEBUG","Error adding account");
        return false;
    }

    public static boolean removeAccount(int feedID,int accountID){
        switch (feedID){
            case 0: {
                    socialAccounts.remove(accountID);
                    return true;
            }
            case 1: {
                    proAccounts.remove(accountID);
                    return true;
            }
            case 2: {
                    emailAccounts.remove(accountID);
                    return true;
            }
        }
        Log.d("DEBUG","Error removing account (invalid feed)");
        return false;
    }

    public boolean addPost(int feedID){
        switch (feedID){
            case 0: {
                    Post newItem = new Post("IT'S A BRAND NEW SOCIAL POST");
                    socialFeedItems.add(0,newItem);
                    socialListAdapter.notifyDataSetChanged();
                    return true;
            }
            case 1: {
                    Post newItem = new Post("NEW BUSINESS IS HAPPENING");
                    proFeedItems.add(0,newItem);
                    proListAdapter.notifyDataSetChanged();
                    return true;
            }
            case 2: {
                    Post newItem = new Post("NEW EMAIL");
                    emailFeedItems.add(0,newItem);
                    emailListAdapter.notifyDataSetChanged();
                    return true;
            }
        }
        Log.d("DEBUG","Error adding post");
        return false;
    }

    public static List<Account> getAccounts(int idx){
        switch (idx){
            case 0: return socialAccounts;
            case 1: return proAccounts;
            case 2: return emailAccounts;
        }
        // should not be reached
        Log.d("DEBUG","Bad getAccounts()");
        return null;
    }
}
