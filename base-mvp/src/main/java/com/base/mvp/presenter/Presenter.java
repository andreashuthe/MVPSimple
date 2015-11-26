package com.base.mvp.presenter;

import com.base.mvp.presenter.listener.PresenterListener;
import com.base.mvp.view.View;

/**
 * Created by andreas_h on 08.11.15.
 */
public interface Presenter<V extends View> {

    public V getView();

    public void addPresenterListener(PresenterListener presenterListener);

    public void removePresenterListener(PresenterListener presenterListener);
}
