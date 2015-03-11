package com.cainwong.demo.mvp.vus;

/**
 * Created by cwong on 3/10/15.
 */
public interface VuCallback<T> {
    void execute(T result);
}
