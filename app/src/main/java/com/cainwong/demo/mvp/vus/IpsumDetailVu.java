package com.cainwong.demo.mvp.vus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cainwong.demo.mvp.R;
import com.cainwong.demo.mvp.data.Ipsum;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumDetailVu implements Vu {

    View view;
    TextView titleView;
    TextView bodyView;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ipsum_detail, container, false);
        titleView = (TextView) view.findViewById(R.id.title);
        bodyView = (TextView) view.findViewById(R.id.body);
    }

    @Override
    public View getView() {
        return view;
    }

    public void setIpsum(Ipsum ipsum){
        titleView.setText(ipsum.title);
        bodyView.setText(ipsum.body);
    }

}
