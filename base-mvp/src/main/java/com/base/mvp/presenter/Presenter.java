package com.base.mvp.presenter;

import com.base.mvp.presenter.listener.PresenterListener;
import com.base.mvp.view.View;

/**
 * Created by andreas_h on 08.11.15.
 */
public interface Presenter<V extends View> {

    V getView();

    void addPresenterListener(PresenterListener presenterListener);

    void removePresenterListener(PresenterListener presenterListener);
}
