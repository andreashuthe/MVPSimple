package com.base.mvp.view;

import com.vaadin.ui.Component;

/**
 * Created by andreas_h on 08.11.15.
 */
public interface VaadinView<VE extends Enum<VE>, C extends Component> extends View {

    /**
     * Gets view implementation.
     *
     * @return the view implementation
     */
    C getViewImplementation ();

    /*@Override void addView(Object id, View view);*/
}
