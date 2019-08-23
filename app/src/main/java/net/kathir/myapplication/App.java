package net.kathir.myapplication;

import android.app.Application;

import androidx.databinding.DataBindingUtil;

import net.kathir.myapplication.mvvmdatabinding.databinding.AppDataBindingComponent;;

public class App extends Application {

    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

    }

    public static App getInstance() {
        return sInstance;
    }
}
