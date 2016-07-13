package socialnews.linccy.com.socialnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Lcc on 2016/7/12.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private String[] items;
    private List<Fragment> fragments;

    public TabAdapter(FragmentManager fm, String[] items, List<Fragment> fragments) {
        super(fm);
        this.items = items;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items[position];
    }
}
