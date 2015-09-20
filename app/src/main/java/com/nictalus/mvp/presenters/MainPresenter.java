package com.nictalus.mvp.presenters;

import com.nictalus.mvp.models.UserModel;
import com.nictalus.mvp.utils.Api;
import com.nictalus.mvp.views.IMainView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * @author mariobama
 * @since 26/08/15
 */
public class MainPresenter implements IMainPresenter {
    private IMainView view;
    private List<UserModel> model;


    public MainPresenter(IMainView mainView) {
        this.view = mainView;
    }

    //Interfaces -----------------------------------------------------------------------------------
    @Override
    public void getUsersFromUrl() {
        // Use retrofit to get json data
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://jsonplaceholder.typicode.com").build();
        Api api = restAdapter.create(Api.class);
        api.getDataFromUrl(new Callback<List<UserModel>>() {
            @Override
            public void success(List<UserModel> list, Response response) {
                // Set the model
                model = list;
                if(model != null && model.size() > 0) {
                    List<String> names = new ArrayList<>();
                    for(int i = 0; i < model.size(); i++) {
                        names.add(model.get(i).getName());
                    }
                    // Call view method to set the name list in the listView
                    view.setUsersInList(names);
                }
            }
            @Override
            public void failure(RetrofitError error) {
                // Call view method to show a toast with an error message
                view.showErrorToast();
            }
        });
    }
    // ---------------------------------------------------------------------------------------------

}