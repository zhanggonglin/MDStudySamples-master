package com.yifeng.mdstudysamples.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yifeng.mdstudysamples.R;
import com.yifeng.mdstudysamples.activity.data.DataGenerator;

import java.util.List;

/**
 * TabLayout实现底部菜单
 * Created by yifeng on 16/8/3.
 */
public class TabLayoutBottomActivity extends BaseActivity {

    private TabLayout mTabTl;
    private Fragment[] tabFragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_bottom);
        mTabTl = (TabLayout) findViewById(R.id.tl_tab);
        tabFragments = DataGenerator.getFragments("FragmentTest");
        initView();
    }

    private void initView() {
        mTabTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
                //方法二改变Tab 状态
                // Tab 选中之后，改变各个Tab的状态
                for (int i = 0; i < mTabTl.getTabCount(); i++) {
                    View view = mTabTl.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.iv_tab);
                    TextView text = (TextView) view.findViewById(R.id.tv_menu_item);
                    if (i == tab.getPosition()) { // 选中状态
                        text.setTextColor(ContextCompat.getColor(mContext,R.color.blue));

                    } else {// 未选中状态
                        text.setTextColor(ContextCompat.getColor(mContext, R.color.black));
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //方法一
       /* mTabTl.addTab(mTabTl.newTab().setIcon(DataGenerator.mTabRes[0]).setText(DataGenerator.mTabTitle[0]));
        mTabTl.addTab(mTabTl.newTab().setIcon(DataGenerator.mTabRes[1]).setText(DataGenerator.mTabTitle[1]));
        mTabTl.addTab(mTabTl.newTab().setIcon(DataGenerator.mTabRes[2]).setText(DataGenerator.mTabTitle[2]));
        mTabTl.addTab(mTabTl.newTab().setIcon(DataGenerator.mTabRes[3]).setText(DataGenerator.mTabTitle[3]));*/

        //方法二，添加自定义布局的tab
        // 提供自定义的布局添加Tab
        for (int i = 0; i < 4; i++) {
            mTabTl.addTab(mTabTl.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }


    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = tabFragments[0];
                break;
            case 1:
                fragment = tabFragments[1];
                break;

            case 2:
                fragment = tabFragments[2];
                break;
            case 3:
                fragment = tabFragments[3];
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flayout, fragment).commit();
        }
    }

}
