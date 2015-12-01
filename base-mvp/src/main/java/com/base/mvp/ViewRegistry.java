package com.base.mvp;

import java.util.EnumMap;
import java.util.Iterator;

import com.base.mvp.view.View;
import com.google.common.collect.Maps;

/**
 * Created by huth on 20.11.2015.
 */
public class ViewRegistry<VE extends Enum<VE>, V extends View> {

    private final V viewRoot;
    private final EnumMap<VE, V> viewEnumMap;

    /**
     * Instantiates a new View registry.
     *
     * @param viewRoot the view root
     * @param mapType  the map type
     */
    public ViewRegistry(V viewRoot, Class<VE> mapType) {
        this.viewRoot = viewRoot;
        this.viewEnumMap = Maps.newEnumMap(mapType);
    }

    /**
     * Add view.
     *
     * @param id   the id
     * @param view the view
     */
    public void addView(VE id, V view){

        viewEnumMap.put(id, view);

    }

    /**
     * Remove view.
     *
     * @param id the id
     */
    public void removeView(VE id) {
        if (viewEnumMap.containsKey(id)) {
            // final Presenter<?> c = presenterMap.get(id);
            viewEnumMap.remove(id);
        }
    }

    /**
     * Find view v.
     *
     * @param id the id
     * @return the v
     */
    public V findView(VE id) {
        if (viewEnumMap.containsKey(id)) {
            return viewEnumMap.get(id);
        } else {
            final Iterator<V> it = viewEnumMap.values().iterator();
            V result = null;
            while (it.hasNext() && result == null) {
                final V view = it.next();
                result = (V) view.findView(id);
            }
            return result;
        }
    }

}
