package com.yul.pic;

import android.app.Application;
import android.content.Context;

public class PicAppliction extends Application {

    private static Context mInstance;

    public static Context getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
