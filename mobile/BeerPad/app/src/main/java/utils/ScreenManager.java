package utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.beerpad.BeerPadSearchActivity;
import com.beerpad.R;
import com.beerpad.SplitBeerActivity;

import homepage.BigPagerHomeFragment;

/**
 * Created by luisalfonsobejaranosanchez on 5/27/17.
 */

public class ScreenManager {

    public void showMainScreen(FragmentActivity origin) {
        FragmentTransaction ft = origin.getSupportFragmentManager().beginTransaction();
        BigPagerHomeFragment bigPagerHomeFragment = new BigPagerHomeFragment();
        ft.replace(R.id.container, bigPagerHomeFragment);
        ft.commit();
    }


    public void showSearchBeerScreen(Activity origin){
        Intent intent = new Intent(origin, BeerPadSearchActivity.class);
        origin.startActivity(intent);
        origin.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void showSplitBeerScreen(Activity origin){
        Intent intent = new Intent(origin, SplitBeerActivity.class);
        origin.startActivity(intent);
        origin.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
