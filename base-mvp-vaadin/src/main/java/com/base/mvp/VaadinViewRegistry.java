package com.base.mvp;

import com.base.mvp.view.VaadinView;
import com.vaadin.ui.Component;

/**
 * Created by huth on 20.11.2015.
 */
public class VaadinViewRegistry<VE extends Enum<VE>, C extends Component> extends ViewRegistry<VE, VaadinView<VE, C>> {

    /**
     * Instantiates a new Vaadin view registry.
     *
     * @param viewRoot the view root
     * @param mapType  the map type
     */
    public VaadinViewRegistry(VaadinView viewRoot, Class<VE> mapType) {
        super(viewRoot, mapType);
    }
}
