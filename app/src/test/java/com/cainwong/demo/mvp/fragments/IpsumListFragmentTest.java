package com.cainwong.demo.mvp.fragments;

import com.cainwong.demo.mvp.adapters.IpsumListAdapter;
import com.cainwong.demo.mvp.events.ItemSelectedEvent;
import com.cainwong.demo.mvp.vus.IpsumListVu;

import org.junit.Before;
import org.junit.Test;

import de.greenrobot.event.EventBus;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumListFragmentTest {

    IpsumListFragment fragment;
    IpsumListVu vu;
    EventBus bus;
    IpsumListAdapter adapter;

    @Before
    public void setup() throws Exception {
        fragment = new IpsumListFragment();
        vu = mock(IpsumListVu.class);
        fragment.vu = vu;
        bus = mock(EventBus.class);
        fragment.bus = bus;
        adapter = mock(IpsumListAdapter.class);
        fragment.adapter = adapter;
    }

    @Test
    public void testOnBindVu(){
        fragment.onBindVu();
        verify(vu).setListAdapter(adapter);
        verify(vu).setSelectCallback(fragment.selectCallback);
    }

    @Test
    public void testSelectCallback(){
        when(adapter.getTitle(1)).thenReturn("TEST");
        fragment.selectCallback.execute(1);
        verify(adapter).getTitle(1);
        verify(bus).postSticky(isA(ItemSelectedEvent.class));
    }

}
