package com.yifeng.mdstudysamples.activity.data;

import android.content.Context;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yifeng.mdstudysamples.R;
import com.yifeng.mdstudysamples.fragment.HomeFragment;
import com.yifeng.mdstudysamples.fragment.ImageFragment;
import com.yifeng.mdstudysamples.fragment.ImageViewFragment;
import com.yifeng.mdstudysamples.fragment.SettingFragment;

/**
 * Created by zhanggonglin on 2018/11/13.
 */

public class DataGenerator {

    public static final int[] mTabRes = new int[]{R.drawable.selector_menu_home1, R.drawable.selector_menu_home2, R.drawable.selector_menu_home3, R.drawable.selector_menu_home4};
    public static final String[] mTabTitle = new String[]{"首页", "发现", "关注", "我的"};

    public static Fragment[] getFragments(String from) {
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance(from + "1");
        fragments[1] = ImageFragment.newInstance(from + "2");
        fragments[2] = ImageViewFragment.newInstance(from + "3");
        fragments[3] = SettingFragment.newInstance(from + "4");
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     *
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tab_layout_custom, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.iv_tab);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tv_menu_item);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
