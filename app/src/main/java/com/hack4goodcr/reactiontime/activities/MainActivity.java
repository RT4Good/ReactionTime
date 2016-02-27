package com.hack4goodcr.reactiontime.activities;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



import com.hack4goodcr.reactiontime.R;


import fragments.MainFragment;
import fragments.balls_game_fragment;
import fragments.historic;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainFragment.OnDataPass{
    private FloatingActionButton fab;
    private int roundsToPlay;
    private int ballsToPlay;


    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInflow = true;
    private boolean mSignInClicked = false;
    private TextView nav_drawer_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.nav_drawer_settings, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        nav_drawer_username = (TextView) findViewById(R.id.nav_drawer_username);

        Fragment fragment = new MainFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment, "mainFragment").commit();
        navigationView.getMenu().getItem(0).setChecked(true);
        // Highlight the selected item, update the title, and close the drawer
        setTitle(getResources().getString(R.string.app_name));

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putIntArray("rounds_balls", new int []{roundsToPlay, ballsToPlay});

                Fragment newFragment = new balls_game_fragment();
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                newFragment.setArguments(bundle);
// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
                transaction.replace(R.id.flContent, newFragment);
                transaction.addToBackStack(null);



// Commit the transaction
                transaction.commit();
                fab.setVisibility(View.INVISIBLE);

            }
        });
    }

    @Override
    public void onDataPass(int rounds, int balls) {
        roundsToPlay = rounds;
        ballsToPlay = balls;
        Log.d("LOG","hello " + rounds + " " + balls);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            Log.d("LOG","backbutooon");
            MainFragment myFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("mainFragment");
            if (myFragment != null && myFragment.isVisible()) {
                fab.setVisibility(View.VISIBLE);
                // add your code here
            }

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_games) {
            fab.setVisibility(View.VISIBLE);
            Fragment fragment = new MainFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment, "historic").commit();
            // Handle the camera action
        } else if (id == R.id.nav_ranking) {
            fab.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_historic) {
            fab.setVisibility(View.INVISIBLE);

            Fragment fragment = new historic();

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment, "historic").commit();

        } else if (id == R.id.nav_settings) {
            fab.setVisibility(View.INVISIBLE);

        } else if (id == R.id.nav_about) {
            fab.setVisibility(View.INVISIBLE);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
