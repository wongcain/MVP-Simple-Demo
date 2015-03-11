package com.cainwong.demo.mvp.fragments;

import com.cainwong.demo.mvp.data.Ipsum;
import com.cainwong.demo.mvp.events.ItemSelectedEvent;
import com.cainwong.demo.mvp.vus.IpsumDetailVu;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import de.greenrobot.event.EventBus;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumDetailFragmentTest {

    IpsumDetailFragment fragment;
    IpsumDetailVu vu;
    EventBus bus;
    Map<String, Ipsum> ipsumMap;
    Ipsum ipsum1 = new Ipsum("TEST 1", "This is test 1");
    Ipsum ipsum2 = new Ipsum("TEST 2", "This is test 2");

    @Before
    public void setup() throws Exception {
        fragment = new IpsumDetailFragment();
        vu = mock(IpsumDetailVu.class);
        fragment.vu = vu;
        bus = mock(EventBus.class);
        fragment.bus = bus;
        ipsumMap = new LinkedHashMap<>();
        ipsumMap.put("TEST 1", ipsum1);
        ipsumMap.put("TEST 2", ipsum2);
        fragment.ipsumMap = ipsumMap;
    }

    @Test
    public void testAfterResume(){
        fragment.afterResume();
        verify(bus).registerSticky(isA(IpsumDetailFragment.class));
    }

    @Test
    public void testBeforePause(){
        fragment.beforePause();
        verify(bus).unregister(isA(IpsumDetailFragment.class));
    }

    @Test
    public void testOnItemSelectedEvent(){
        fragment.onEvent(new ItemSelectedEvent("TEST 2"));
        verify(vu).setIpsum(ipsum2);
    }

}
