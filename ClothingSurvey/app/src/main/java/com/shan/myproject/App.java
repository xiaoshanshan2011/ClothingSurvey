package com.shan.myproject;


import android.app.Application;

/**
 * Created by chenjnshan on 2016/7/5.
 */
public class App extends Application {
    private static App app;
    //public boolean isSlidingClose = true;//是否测滑关闭activity

    @Override
    public void onCreate() {
        super.onCreate();
        app = (App) getApplicationContext();
    }

    /**
     * 获取Application
     *
     * @return
     */
    public static App getInstance() {
        return app;
    }

}
