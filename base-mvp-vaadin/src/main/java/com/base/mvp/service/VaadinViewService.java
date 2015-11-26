package com.base.mvp.service;

import com.base.mvp.presenter.Presenter;
import com.base.mvp.view.VaadinView;

/**
 * Created by huth on 23.11.2015.
 */
public interface VaadinViewService extends ViewService<VaadinView> {

    /**
     * Find view class class.
     *
     * @param presenter the presenter
     * @return the class
     */
    @Override Class<VaadinView> findViewClass(Presenter presenter);
}
