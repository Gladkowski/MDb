package dev.gladkowski.mdb;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import net.danlew.android.joda.JodaTimeAndroid;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dev.gladkowski.mdb.di.app.component.DaggerAppComponent;

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        DaggerAppComponent
                .builder()
                .create(this)
                .inject(this);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

}
