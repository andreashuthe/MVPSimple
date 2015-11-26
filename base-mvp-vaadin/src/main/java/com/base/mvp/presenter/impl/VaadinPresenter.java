package com.base.mvp.presenter.impl;

import com.base.mvp.service.VaadinViewService;
import com.base.mvp.model.VaadinModel;
import com.base.mvp.view.VaadinView;

/**
 * Created by andreas_h on 08.11.15.
 */
public abstract class VaadinPresenter<M extends VaadinModel> extends PresenterImpl<VaadinView, M> {

    /**
     *
     * @param viewVaadinViewService
     * @param modelClass
     */
    public VaadinPresenter(VaadinViewService viewVaadinViewService, Class<M> modelClass) {
        super(viewVaadinViewService, modelClass);
    }

    @Override
    public VaadinView getView() {
        return super.getView();
    }

    @Override
    protected M getModel() {
        return super.getModel();
    }
}
