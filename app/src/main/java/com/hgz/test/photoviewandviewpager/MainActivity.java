package com.hgz.test.photoviewandviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.hgz.test.photoviewandviewpager.dialog.MyDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> url=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tvIntent);
        url.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-05-18251898_1013302395468665_8734429858911748096_n.jpg");
        url.add("http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-04-18299181_1306649979420798_1108869403736276992_n.jpg");
        url.add("http://ww1.sinaimg.cn/large/61e74233ly1feuogwvg27j20p00zkqe7.jpg");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到大图页面
                new MyDialog(MainActivity.this,url).show();
            }
        });
    }
}
