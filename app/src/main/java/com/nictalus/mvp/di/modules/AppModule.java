package com.nictalus.mvp.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * @author mariobama
 * @since 7/09/15
 */
@Module
public class AppModule {

    private Context mContext;
    private SharedPreferences preferences;


    public AppModule(Context context) {
        mContext = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    @Provides @Singleton
    Context providesApplicationContext() {
        return mContext;
    }

    @Provides @Singleton
    SharedPreferences providesSharedPreferences() {
        return preferences;
    }

}