package me.tysheng.rxfastcachedemo;

import android.app.Application;

import me.tysheng.rxfastcache.RxFastCache;

/**
 * Created by tysheng
 * Date: 2016/9/24 09:15.
 * Email: tyshengsx@gmail.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        RxFastCache.init(this);
    }
}
