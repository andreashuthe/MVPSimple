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
public abstract class VaadinViewImpl<VE extends Enum<VE>, C extends Component> implements VaadinView{

    private C baseComponent;
    private EventBus eventBus;
    private ViewRegistry viewRegistry;

    /**
     * Instantiates a new Vaadin view.
     *
     * @param viewEnumClass      the view enum class
     * @param baseComponentClass the base component class
     */
    public VaadinViewImpl(Class<VE> viewEnumClass, Class<C> baseComponentClass) {
        try {
            this.baseComponent = (C) baseComponentClass.newInstance();
            this.viewRegistry = new ViewRegistry(this, viewEnumClass);
        } catch (Exception e) {
            this.baseComponent = null;
        }

    }

    /**
     * Gets view implementation.
     *
     * @return the view implementation
     */
    public C getViewImplementation() {
        return this.baseComponent;
    }

    /**
     *
     * @return
     */
    public Component getViewImplementation(Object id) {
        if (id instanceof Enum){
            final View view = viewRegistry.findView((Enum) id);

            final Component component = (view instanceof VaadinView) ? ((VaadinView) view).getViewImplementation() : null;
            return component;

        } else {
            return null;
        }
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

    @Override
    public View findView(Object id) {
        if (id instanceof Enum){
            return viewRegistry.findView((Enum) id);
        } else {
            return null;
        }
    }

    @Override
    public void addView(Object id, View view) {
        viewRegistry.addView((Enum) id, view);
    }
}
