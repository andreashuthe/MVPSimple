package com.base.mvp.view;

import com.google.common.eventbus.EventBus;

/**
 * Created by andreas_h on 08.11.15.
 */
public interface View {

    /**
     * Post construct.
     *
     * @param eventBus the event bus
     */
    void postConstruct (final EventBus eventBus);

    /**
     * Init.
     */
    public void init();

    /**
     * Gets event bus.
     *
     * @return the event bus
     */
    public EventBus getEventBus();

    /**
     * Find view v.
     *
     * @param id the id
     * @return the v
     */
    public View findView(Object id);

    /**
     * Add view.
     *
     * @param id   the id
     * @param view the view
     */
    public void addView(Object id, View view);

    /**
     * Init view components.
     */
    public void initViewComponents();

}
