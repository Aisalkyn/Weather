package com.example.nestana.myweather;

import android.app.Application;


import com.example.nestana.myweather.other.ForumService;
import com.example.nestana.myweather.other.Network;

import static com.example.nestana.myweather.other.Const.BASE_URL;


public class StartApplication extends Application {
    private ForumService service;

    @Override
    public void onCreate() {
        super.onCreate();
        service = Network.Companion.initService(INSTANCE.getBASE_URL());
    }

    public ForumService getService() {
        return service;
    }


}