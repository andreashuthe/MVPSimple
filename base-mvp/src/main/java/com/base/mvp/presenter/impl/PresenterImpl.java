package com.base.mvp.presenter.impl;

import com.base.mvp.presenter.listener.PresenterListener;
import com.base.mvp.service.ViewService;
import com.google.common.eventbus.EventBus;
import com.base.mvp.model.Model;
import com.base.mvp.presenter.Presenter;
import com.base.mvp.view.View;

/**
 * Created by andreas_h on 08.11.15.
 */
public abstract class PresenterImpl<V extends View, M extends Model> implements Presenter<V>{

    private V view;
    private M model;
    private final ViewService viewService;
    private final Class<V> viewClass;
    private final Class<M> modelClass;
    private final EventBus eventBus = new EventBus();

    /**
     * Instantiates a new Presenter.
     *
     * @param viewService the view service
     * @param modelClass  the model class
     */
    protected PresenterImpl(final ViewService<V> viewService, final Class<M> modelClass) {

        preConstruct();
        this.viewService = viewService;

        this.viewClass = viewService.findViewClass(this);
        this.modelClass = modelClass;

        if (eventBus != null) {
            eventBus.register(this);
        }
        construct(eventBus);

        postConstruct();

        init();
    }

    /**
     * Pre construct.
     */
    protected abstract void preConstruct();

    /**
     * Post construct.
     */
    protected abstract void postConstruct();

    /**
     * Construct.
     *
     * @param eventBus the event bus
     */
    protected void construct(EventBus eventBus) {
        try{
            this.view = createView(eventBus);
            this.model = createModel();
            this.model.init();
            this.view.init();
        } catch (Exception rE){
           // log.error("BasePresenter init(): ", rE);
        }

    }

    /**
     * Init.
     */
    protected void init(){
        initView();
    }

    /**
     * Init view.
     */
    protected void initView(){
        this.view.initViewComponents();
    }

    /**
     * Create view v.
     *
     * @param eventBus the event bus
     * @return the v
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     */
    protected V createView(EventBus eventBus) throws InstantiationException,
            IllegalAccessException{

        final V view = (V) viewClass.newInstance();
        view.postConstruct(eventBus);

        return view;
    }

    /**
     * Create model m.
     *
     * @return the m
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     */
    protected M createModel() throws InstantiationException,
            IllegalAccessException{
        return (M) modelClass.newInstance();
    }

    /**
     * Gets view.
     *
     * @return the view
     */
    public V getView() {
        return this.view;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    protected M getModel() {
        return model;
    }

    /**
     * Gets event bus.
     *
     * @return the event bus
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    /**
     * Add presenter listener.
     *
     * @param presenterListener the presenter listener
     */
    @Override
    public void addPresenterListener(PresenterListener presenterListener) {
        getEventBus().register(presenterListener);
    }

    /**
     * Remove presenter listener.
     *
     * @param presenterListener the presenter listener
     */
    @Override
    public void removePresenterListener(PresenterListener presenterListener) {
        getEventBus().unregister(presenterListener);
    }
}
