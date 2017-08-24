package com.hgz.test.photoviewandviewpager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MyViewpagerAdapter extends PagerAdapter {
    private Context context;
    private List<String> url;
    public MyViewpagerAdapter(Context context, List<String> url){
        this.context=context;
        this.url=url;
    }
    @Override
    public int getCount() {
        return url.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(context);
        ImageLoader.getInstance().displayImage(url.get(position),photoView);
        container.addView(photoView);
        return photoView;
    }
}
