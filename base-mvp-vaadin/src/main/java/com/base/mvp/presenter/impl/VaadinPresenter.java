package com.base.mvp.presenter.impl;

import com.base.mvp.service.VaadinViewService;
import com.base.mvp.model.VaadinModel;
import com.base.mvp.view.VaadinView;

/**
 * Created by andreas_h on 08.11.15.
 */
public abstract class VaadinPresenter<V extends VaadinView,M extends VaadinModel> extends PresenterImpl<V, M> {

    /**
     *
     * @param viewVaadinViewService
     * @param modelClass
     */
    public VaadinPresenter(VaadinViewService<V> viewVaadinViewService, Class<M> modelClass) {
        super(viewVaadinViewService, modelClass);
    }

    @Override
    public V getView() {
        return super.getView();
    }

    @Override
    protected M getModel() {
        return super.getModel();
    }
}
