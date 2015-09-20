package com.nictalus.mvp.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.nictalus.mvp.di.modules.AppModule;
import com.nictalus.mvp.views.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


/**
 * @author mariobama
 * @since 7/09/15
 */
@Singleton @Component(
        modules = {AppModule.class}
)

public interface AppComponent {

    void inject(MainActivity mainActivity);

    Context context();

    SharedPreferences prefs();

}