package com.nictalus.mvp.di;

import android.app.Application;

import com.nictalus.mvp.di.components.AppComponent;
import com.nictalus.mvp.di.modules.AppModule;
import com.nictalus.mvp.di.components.DaggerAppComponent;


/**
 * @author mariobama
 * @since 08/09/15
 */
public class MVPApplication extends Application {

    private AppComponent mComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        // DaggerAppComponent is a method that creates once you rebuild the project
        //      and the name is Dagger%COMPONENT_NAME%, in this case AppComponent is the
        //      name of the component.
        // The method appModule, also depends on the name of the module.
        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return mComponent;
    }

}