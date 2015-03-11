package com.cainwong.demo.mvp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cainwong.demo.mvp.vus.Vu;

import de.greenrobot.event.EventBus;

/**
 * Created by cwong on 3/10/15.
 */
public abstract class BasePresenterFragment<V extends Vu> extends Fragment {

    protected V vu;
    protected EventBus bus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = EventBus.getDefault();
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        try {
            vu = getVuClass().newInstance();
            vu.init(inflater, container);
            onBindVu();
            view = vu.getView();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public final void onDestroyView() {
        onDestroyVu();
        vu = null;
        super.onDestroyView();
    }

    protected void onDestroyVu() {};

    @Override
    public final void onPause() {
        beforePause();
        super.onPause();
    }

    protected void beforePause(){}

    @Override
    public final void onResume() {
        super.onResume();
        afterResume();
    }

    protected void afterResume(){}

    protected void onBindVu(){};

    protected abstract Class<V> getVuClass();

}