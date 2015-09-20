package com.nictalus.mvp.utils;

import com.nictalus.mvp.models.UserModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * @author mariobama
 * @since 26/08/15
 */
public interface Api {

    @GET("/users") void getDataFromUrl(Callback<List<UserModel>> response);

}