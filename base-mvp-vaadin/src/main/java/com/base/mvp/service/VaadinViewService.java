package com.base.mvp.service;

import com.base.mvp.presenter.Presenter;
import com.base.mvp.view.VaadinView;

/**
 * Created by huth on 23.11.2015.
 */
public interface VaadinViewService<V extends VaadinView> extends ViewService<V> {

    /**
     * Find view class class.
     *
     * @param presenter the presenter
     * @return the class
     */
    @Override Class<V> findViewClass(Presenter presenter);
}
