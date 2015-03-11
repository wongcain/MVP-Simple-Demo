package com.cainwong.demo.mvp.adapters;

import com.cainwong.demo.mvp.data.Ipsum;
import com.cainwong.demo.mvp.vus.IpsumListItemVu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumListAdapter extends BasePresenterAdapter<IpsumListItemVu> {

    List<String> titles = new ArrayList<>(Ipsum.VALUES_MAP.keySet());

    @Override
    protected void onBindListItemVu(int position) {
        String title = titles.get(position);
        vu.setTitle(title);
    }

    @Override
    protected Class<IpsumListItemVu> getVuClass() {
        return IpsumListItemVu.class;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String getTitle(int position) {
        return (String) getItem(position);
    }

}
