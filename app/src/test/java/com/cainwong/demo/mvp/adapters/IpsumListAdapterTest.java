package com.cainwong.demo.mvp.adapters;

import com.cainwong.demo.mvp.vus.IpsumListItemVu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by cwong on 3/10/15.
 */
public class IpsumListAdapterTest {

    IpsumListAdapter adapter;
    IpsumListItemVu vu;
    List<String> titles;

    @Before
    public void setup() throws Exception {
        adapter = new IpsumListAdapter();
        vu = mock(IpsumListItemVu.class);
        adapter.vu = vu;
        titles = new ArrayList<>();
        titles.add("TEST 1");
        titles.add("TEST 2");
        adapter.titles = titles;
    }

    @Test
    public void testOnBindListItem() throws Exception {
        adapter.onBindListItemVu(0);
        verify(vu).setTitle("TEST 1");
        adapter.onBindListItemVu(1);
        verify(vu).setTitle("TEST 2");
    }

    @Test
    public void testGetCount() throws Exception {
        assertThat(adapter.getCount()).isEqualTo(2);
        titles.add("TEST 3");
        assertThat(adapter.getCount()).isEqualTo(3);
    }

    @Test
    public void testGetTitle() throws Exception {
        assertThat(adapter.getTitle(0)).isEqualTo("TEST 1");
        assertThat(adapter.getTitle(1)).isEqualTo("TEST 2");
    }

}
