package utils;

import android.app.Application;

/**
 * Created by luisalfonsobejaranosanchez on 5/27/17.
 */

public class AppHelper extends Application {

    private static AppHelper instance;
    public static final ScreenManager screenManager = new ScreenManager();

    public static AppHelper getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
