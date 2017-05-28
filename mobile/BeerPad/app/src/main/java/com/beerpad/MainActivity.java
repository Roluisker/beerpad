package com.beerpad;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import homepage.BigPagerHomeFragment;
import homepage.TripActionsFragment;
import utils.AppHelper;

public class MainActivity extends AppCompatActivity implements BigPagerHomeFragment.SlidePanelListener,
        TripActionsFragment.OnTabSelectedListener {

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private TripActionsFragment tripFragment;

    private Toolbar mToolbar;

    private int mCurrentSelectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolBar();

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        } else {
            AppHelper.screenManager.showMainScreen(this);
            slideTripPanelUp();
        }

    }

    @Override
    public void slideTripPanelUp() {
        tripFragment = TripActionsFragment.newInstance(true);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in_bottom, R.anim.slide_out_bottom_with_fade_out);
        ft.replace(R.id.panel_container, tripFragment);
        ft.commit();
    }

    @Override
    public void slideTripPanelDown() {
        if (tripFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fade_in_bottom, R.anim.slide_out_bottom_with_fade_out);
            ft.remove(tripFragment);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setUpToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
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


    @Override
    public void onTabSelected(int position) {

    }

}
