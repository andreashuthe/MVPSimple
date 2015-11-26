package com.base.mvp.view.impl;

import com.base.mvp.VaadinViewRegistry;
import com.base.mvp.ViewRegistry;
import com.base.mvp.view.View;
import com.google.common.eventbus.EventBus;
import com.base.mvp.view.VaadinView;
import com.vaadin.ui.Component;

/**
 * Created by andreas_h on 08.11.15.
 */
public abstract class VaadinViewImpl<VE extends Enum<VE>,C extends Component> implements VaadinView<VE,C> {

    private C baseComponent;
    private EventBus eventBus;
    private VaadinViewRegistry<VE, C> viewRegistry;

    /**
     * Instantiates a new Vaadin view.
     *
     * @param viewEnumClass      the view enum class
     * @param baseComponentClass the base component class
     */
    public VaadinViewImpl(Class<VE> viewEnumClass, Class<C> baseComponentClass) {
        try {
            this.baseComponent = (C) baseComponentClass.newInstance();
            this.viewRegistry = new VaadinViewRegistry<VE, C>(this, viewEnumClass);
        } catch (Exception e) {
            this.baseComponent = null;
        }

    }

    /**
     * Gets view implementation.
     *
     * @return the view implementation
     */
    @Override
    public C getViewImplementation() {
        return this.baseComponent;
    }

    /**
     * Init.
     */
    @Override
    public void init() {
    }

    /**
     * Post construct.
     *
     * @param eventBus the event bus
     */
    @Override
    public void postConstruct(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    /**
     * Gets event bus.
     *
     * @return the event bus
     */
    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    /**
     * Find view vaadin view.
     *
     * @param id the id
     * @return the vaadin view
     */
    @Override
    public VaadinView findView(Object id) {
        if (id instanceof Enum){
            return viewRegistry.findView((VE) id);
        }

        return null;
    }

    /**
     * Add view.
     *
     * @param id   the id
     * @param view the view
     */
    @Override
    public void addView(Object id, VaadinView view) {
        if (id instanceof Enum) {
            viewRegistry.addView((VE) id, view);
        }
    }
}
