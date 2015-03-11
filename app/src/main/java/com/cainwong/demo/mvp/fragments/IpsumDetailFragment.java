package com.cainwong.demo.mvp.fragments;

import com.cainwong.demo.mvp.data.Ipsum;
import com.cainwong.demo.mvp.events.ItemSelectedEvent;
import com.cainwong.demo.mvp.vus.IpsumDetailVu;

import java.util.Map;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumDetailFragment extends BasePresenterFragment<IpsumDetailVu> {

    Map<String, Ipsum> ipsumMap = Ipsum.VALUES_MAP;

    @Override
    public void afterResume() {
        bus.registerSticky(this);
    }

    @Override
    public void beforePause() {
        bus.unregister(this);
    }

    @Override
    protected Class<IpsumDetailVu> getVuClass() {
        return IpsumDetailVu.class;
    }

    public void onEvent(ItemSelectedEvent event){
        vu.setIpsum(ipsumMap.get(event.title));
    }

    public static IpsumDetailFragment newInstance(){
        return new IpsumDetailFragment();
    }

}
