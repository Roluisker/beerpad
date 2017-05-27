package utils;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.beerpad.R;

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

}
