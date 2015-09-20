package com.nictalus.mvp.views;

import java.util.List;


/**
 * @author mariobama
 * @since 26/08/15
 */
public interface IMainView {

    void setUsersInList(List<String> list);
    void showErrorToast();

}