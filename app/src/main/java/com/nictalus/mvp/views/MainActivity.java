package com.nictalus.mvp.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nictalus.mvp.di.MVPApplication;
import com.nictalus.mvp.R;
import com.nictalus.mvp.presenters.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * @author mariobama
 * @since 26/08/15
 */
public class MainActivity extends AppCompatActivity implements IMainView {
    protected MainPresenter presenter;
    protected @Bind(R.id.list) ListView list;
    // Other attributes and views
    //@Inject Context mContext;
    //@Inject SharedPreferences mPrefs;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inject views
        ButterKnife.bind(this);
        // Two ways to inject with dagger. The next is one of them, just using the method you want:
        //      ((MVPApplication) getApplication()).getComponent().context());.
        // The other way is put the object as attribute annotated with @Inject
        //      and in the onCreate method type:
        //      ((MVPApplication) getApplication()).getComponent().inject(this); and then you
        //      can use the object injected.
        // There's a third way that is using constructor injection by annotating your constructor
        //      with @Inject, and letting Dagger create your class for you.
        if(getApplicationContext().
                equals(((MVPApplication) getApplication()).getComponent().context())) {
            Log.d("DAGGER", "Correct Injection of Application context, the first way");
        }
        else {
            Log.d("DAGGER", "Incorrect Injection, the first way");
        }
        int count = ((MVPApplication) getApplication()).getComponent().prefs().getInt("Count", 0);
        count++;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            ((MVPApplication) getApplication()).getComponent().prefs()
                    .edit().putInt("Count", count).apply();
        }
        else {
            ((MVPApplication) getApplication()).getComponent().prefs()
                    .edit().putInt("Count", count).commit();
        }
        /*((MVPApplication) getApplication()).getComponent().inject(this);
        if(getApplicationContext().equals(mContext)) {
            Log.d("DAGGER", "Correct Injection of Application context, the second way");
        }
        else {
            Log.d("DAGGER", "Incorrect Injection, the second way");
        }
        int count = mPrefs.getInt("Count", 0);
        count++;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            mPrefs.edit().putInt("Count", count).apply();
        }
        else {
            mPrefs.edit().putInt("Count", count).commit();
        }*/
        // Show a progress dialog
        pd = new ProgressDialog(MainActivity.this);
        pd.setCancelable(false);
        pd.setMessage("Loading content ...");
        pd.show();
        // Set presenter
        presenter = new MainPresenter(this);
        // Call presenter method to get json data from url
        presenter.getUsersFromUrl();
    }

    //Interfaces -----------------------------------------------------------------------------------
    @Override
    public void setUsersInList(List<String> nameList) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, nameList);
        list.setAdapter(adapter);
        pd.dismiss();
    }

    @Override
    public void showErrorToast() {
        pd.dismiss();
        Toast.makeText(getApplicationContext(), "Error while loading content",
                Toast.LENGTH_LONG).show();
    }

}