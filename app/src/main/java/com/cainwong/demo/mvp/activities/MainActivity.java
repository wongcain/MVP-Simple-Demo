package com.cainwong.demo.mvp.activities;

import com.cainwong.demo.mvp.events.ItemSelectedEvent;
import com.cainwong.demo.mvp.fragments.IpsumDetailFragment;
import com.cainwong.demo.mvp.fragments.IpsumListFragment;
import com.cainwong.demo.mvp.vus.MainVu;


public class MainActivity extends BasePresenterActivity<MainVu> {

    @Override
    protected void onBindVu() {
        fm.beginTransaction()
                .replace(vu.getContainerId(), IpsumListFragment.newInstance())
                .commit();
    }

    @Override
    protected void afterResume() {
        bus.registerSticky(this);
    }

    @Override
    protected void beforePause() {
        bus.unregister(this);
    }

    @Override
    public boolean handleBackPressed() {
        bus.removeAllStickyEvents();
        return false;
    }

    @Override
    protected Class<MainVu> getVuClass() {
        return MainVu.class;
    }

    public void onEvent(ItemSelectedEvent event){
        fm.beginTransaction()
                .replace(vu.getContainerId(), IpsumDetailFragment.newInstance())
                .addToBackStack(IpsumDetailFragment.class.getName())
                .commit();
    }

}
