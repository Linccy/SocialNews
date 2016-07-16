package socialnews.linccy.com.socialnews.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import socialnews.linccy.com.socialnews.R;
import socialnews.linccy.com.socialnews.adapter.SectionsPagerAdapter;

/**
 * Created by Lcc on 2016/7/12.
 */

public class NewsFragment extends BaseFragment {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.container)
    ViewPager container;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("新闻");

        String[] items = new String[]{"旅游新闻", "今日要闻", "科技新闻", "游戏新闻"};
        List<NewsChildFragment> fragments = new ArrayList<NewsChildFragment>();

        for (
                int i = 0;
                i < 4; i++)

        {
            NewsChildFragment fragment = new NewsChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sectionnum", i + 1);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mSectionsPagerAdapter = new

                SectionsPagerAdapter(getChildFragmentManager(), items, fragments

        );

        // Set up the ViewPager with the sections adapter.
        container.setAdapter(mSectionsPagerAdapter);
        container.setCurrentItem(0);
        container.setOffscreenPageLimit(1);
        container.setOnPageChangeListener(new ViewPager.OnPageChangeListener()

                                          {
                                              @Override
                                              public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                              }

                                              @Override
                                              public void onPageSelected(int position) {
                                                  Log.d("选择的页面：", String.valueOf(position));
                                              }

                                              @Override
                                              public void onPageScrollStateChanged(int state) {

                                              }
                                          }

        );

        tabs.setupWithViewPager(container);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    @OnClick(R.id.fab)
    public void onClick() {
    }
}
