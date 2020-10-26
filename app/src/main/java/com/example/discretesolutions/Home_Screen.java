package com.example.discretesolutions;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Home_Screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView nav_view;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        drawer = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //Toolbar is used as ActionBar
        setSupportActionBar(toolbar);

        //Listening to whether Navigation Items are selected or not
        nav_view.setNavigationItemSelectedListener(this);

        //For sliding i.e toggling of Navigation Drawer to and fro
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //when activity is started for first time or when when we go back and again the start activity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home_Fragment()).commit();

            nav_view.setCheckedItem(R.id.nav_home);             //initially Home item is selected in Navigation Drawer
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                //Replacing FrameLayout in HomeScreen with corresponding Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Home_Fragment()).commit();
                break;
            case R.id.nav_edit_profile:

                break;
            case R.id.nav_settings:

                break;
            case R.id.nav_about_us:

                break;
            case R.id.nav_share:

                break;
            case R.id.nav_rate_us:

                break;
            case R.id.nav_logout:

                break;

        }
        return true;
    }

    @Override
    //When swiping from edges of phone, we need to return to HomeScreen from the Navigation Drawer instead of Closing of App
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


}
