package socialnews.linccy.com.socialnews.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * 基础Activity
 * Created by Lcc on 2016/7/7.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        setListener();

    }

    /**
     * 获取布局文件id
     */
    public abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 设置监听器
     */
    protected void setListener() {

    }

    /**
     * 跳转到其他Activity
     *
     * @param cls      目标Avtivity
     * @param isFinish 开启后是否关闭当前Activity
     */
    protected void jumpActivity(Class cls, boolean isFinish) {
        Intent mIntent = new Intent(this, cls);
        startActivity(mIntent);
        if (isFinish) {
            this.finish();
        } else {

        }
    }

    /**
     * Fragment之间的跳转
     *
     * @param oldFragment 当前显示的Fragment
     * @param newFragment 将要跳转到的Fragment
     * @param id
     * @param tag
     */
    protected void jumpFragment(Fragment oldFragment, Fragment newFragment, int id, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (newFragment != null) {
            transaction.add(id, newFragment, tag);
        } else {
            transaction.hide(oldFragment);
            if (newFragment.isAdded()) {
                transaction.show(newFragment);
            } else {
                transaction.add(id, newFragment, tag);
            }
        }
    }
}
