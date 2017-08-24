package com.hgz.test.photoviewandviewpager.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.hgz.test.photoviewandviewpager.R;
import com.hgz.test.photoviewandviewpager.adapter.MyViewpagerAdapter;
import com.hgz.test.photoviewandviewpager.view.MyViewpager;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MyDialog extends Dialog {
    private List<String> url;
    private Activity context;
    public MyDialog(@NonNull Activity context, List<String> url) {
        super(context,R.style.dialog_theme);
        this.url=url;
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        //拿屏幕的宽高,只有activity有getWindowManager这个方法,所有我们要强转成activity,
        // dialog是挂载到activity上的,直接getContext就是他的activity
        WindowManager windowManager = context.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        //设置diaolog为全屏
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x=0;
        attributes.y=0;
        attributes.width=widthPixels;
        attributes.height=heightPixels;
        window.setAttributes(attributes);

        //找到自己定义的viewpager控件
        MyViewpager myViewpager = (MyViewpager) findViewById(R.id.myViewpager);
        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        MyViewpagerAdapter myViewpagerAdapter = new MyViewpagerAdapter(getContext(),url);
        myViewpager.setAdapter(myViewpagerAdapter);
        tvTitle.setText("1/"+url.size());
        myViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvTitle.setText(position+1+"/"+url.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
