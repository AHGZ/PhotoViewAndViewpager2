package com.hgz.test.photoviewandviewpager.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by Administrator on 2017/8/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(this);
    }
    public static void initImageLoader(Context context){
        String path = Environment.getExternalStorageDirectory() + "/" + "Image";
        File file = new File(path);
        //File cacheDir= StorageUtils.getOwnCacheDirectory(context,"universalimageloader/Cache");
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(100, 100)//配置内存缓存图片的尺寸
                .memoryCacheSize(2 * 1024 * 1024)//配置内存缓存的大小  例如 : 2* 1024 * 1024 = 2MB
                .threadPoolSize(3)//配置加载图片的线程数
                .threadPriority(1000)//配置线程的优先级
                .diskCache(new UnlimitedDiskCache(file))//UnlimitedDiskCache 限制这个图片的缓存路径
                .diskCacheSize(50 * 1024 * 1024)//在sdcard缓存50MB
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//MD5这种方式生成缓存文件的名字
                .diskCacheFileCount(20)//配置sdcard缓存文件的数量
                .writeDebugLogs() //打印加载图片的log日志，跟据自己的需求配置
                .build();//配置构建完成
        ImageLoader.getInstance().init(configuration);
    }
}
