package socialnews.linccy.com.socialnews.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

import socialnews.linccy.com.socialnews.fragment.NewsListFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private String[] sectionitems;
    private List<NewsListFragment> fragments;

    public SectionsPagerAdapter(FragmentManager fm, String[] sectionitems, List<NewsListFragment> fragments) {
        super(fm);
        this.sectionitems = sectionitems;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return NewsListFragment.newInstance(position + 1);
        Bundle bundle = new Bundle();
        bundle.putInt("STATE", position + 1);
        fragments.get(position).setArguments(bundle);
        Log.d("页面", String.valueOf(position+1));
        return fragments.get(position);

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return sectionitems[position];
    }


}
