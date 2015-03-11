package com.cainwong.demo.mvp.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.cainwong.demo.mvp.events.ItemSelectedEvent;
import com.cainwong.demo.mvp.fragments.IpsumDetailFragment;
import com.cainwong.demo.mvp.fragments.IpsumListFragment;
import com.cainwong.demo.mvp.vus.MainVu;

import org.junit.Before;
import org.junit.Test;

import de.greenrobot.event.EventBus;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.assertj.core.api.Assertions.*;


/**
 * Created by cwong on 3/10/15.
 */
public class MainActivityTest {

    static int CONTAINER_ID = 1;

    MainActivity activity;
    MainVu vu;
    EventBus bus;
    FragmentManager fm;
    FragmentTransaction ft;

    @Before
    public void setup() throws Exception {
        activity = new MainActivity();
        vu = mock(MainVu.class);
        when(vu.getContainerId()).thenReturn(CONTAINER_ID);
        activity.vu = vu;
        bus = mock(EventBus.class);
        activity.bus = bus;
        fm = mock(FragmentManager.class);
        activity.fm = fm;
        ft = mock(FragmentTransaction.class);
        when(fm.beginTransaction()).thenReturn(ft);
        when(ft.replace(anyInt(), any(Fragment.class))).thenReturn(ft);
        when(ft.addToBackStack(anyString())).thenReturn(ft);
    }

    @Test
    public void testOnBindVu(){
        activity.onBindVu();
        verify(fm).beginTransaction();
        verify(ft).replace(eq(CONTAINER_ID), isA(IpsumListFragment.class));
        verify(ft).commit();
        verifyNoMoreInteractions(fm, ft);
    }

    @Test
    public void testAfterResume(){
        activity.afterResume();
        verify(bus).registerSticky(isA(MainActivity.class));
    }

    @Test
    public void testBeforePause(){
        activity.beforePause();
        verify(bus).unregister(isA(MainActivity.class));
    }

    @Test
    public void testOnBackPressed(){
        assertThat(activity.handleBackPressed()).isFalse();
        verify(bus).removeAllStickyEvents();
    }

    @Test
    public void testOnItemSelectedEvent(){
        activity.onEvent(new ItemSelectedEvent(""));
        verify(fm).beginTransaction();
        verify(ft).replace(eq(CONTAINER_ID), isA(IpsumDetailFragment.class));
        verify(ft).addToBackStack(isA(String.class));
        verify(ft).commit();
        verifyNoMoreInteractions(fm, ft);
    }

}
