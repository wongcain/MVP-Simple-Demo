package com.cainwong.demo.mvp.vus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cainwong.demo.mvp.R;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumListItemVu implements Vu {

    View view;
    TextView titleView;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ipsum_list_item, container, false);
        titleView = (TextView) view.findViewById(R.id.title);
    }

    @Override
    public View getView() {
        return view;
    }

    public void setTitle(String title){
        titleView.setText(title);
    }

}
