package socialnews.linccy.com.socialnews.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import socialnews.linccy.com.socialnews.R;
import socialnews.linccy.com.socialnews.view.SlidingTabLayout;
import socialnews.linccy.com.socialnews.adapter.TabAdapter;

/**
 * Created by Lcc on 2016/7/12.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.slid_top)
    SlidingTabLayout slidTop;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    TabAdapter tabAdapter;
    String[] items = new String[]{"旅游新闻", "今日要闻", "科技新闻", "游戏新闻"};

    @Override
    protected void initData() {
        super.initData();
        slidTop.setSelectedIndicatorColors(Color.WHITE);
        slidTop.setDividerColors(Color.TRANSPARENT);

        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i < 4; i++) {
            Fragment fragment = new NewsListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("STATE", i + 1);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        tabAdapter = new TabAdapter(getChildFragmentManager(), items, fragments);
        vpContent.setAdapter(tabAdapter);
        slidTop.setViewPager(vpContent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View v) {

    }
}
