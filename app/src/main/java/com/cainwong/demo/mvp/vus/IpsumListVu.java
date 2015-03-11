package com.cainwong.demo.mvp.vus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cainwong.demo.mvp.R;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumListVu implements Vu {

    View view;
    ListView listView;

    VuCallback<Integer> selectCallback;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ipsum_list, container, false);
        listView = (ListView) view.findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if(selectCallback!=null){
                    selectCallback.execute(position);
                }
            }
        });
    }

    @Override
    public View getView() {
        return view;
    }

    public void setListAdapter(ListAdapter adapter){
        listView.setAdapter(adapter);
    }

    public void setSelectCallback(VuCallback<Integer> selectCallback) {
        this.selectCallback = selectCallback;
    }
}
