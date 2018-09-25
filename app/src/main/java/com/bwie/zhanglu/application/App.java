package com.bwie.zhanglu.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author Administrator QQ:1228717266
 * @name Gouwuche
 * @class name：com.bwie.zhanglu.application
 * @time 2018/9/22 10:29
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
