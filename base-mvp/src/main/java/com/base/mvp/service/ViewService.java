package com.base.mvp.service;

import com.base.mvp.presenter.Presenter;
import com.base.mvp.view.View;

/**
 * Created by huth on 23.11.2015.
 */
public interface ViewService<V extends View> {

    /**
     *
     * @param presenter
     * @return
     */
    Class<V> findViewClass(Presenter presenter);

}
