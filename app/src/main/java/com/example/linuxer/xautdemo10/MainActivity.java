package com.example.linuxer.xautdemo10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends AppCompatActivity {
    MapView mapView = null;
    private BaiduMap baiduMap;
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext，不能是this或者activity.class
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.location);
        //获取地图组件
        mapView = (MapView)findViewById(R.id.bmapView);
        //两个按钮，一个现实普通地图，一个实现卫星地图
        button1 = (Button)findViewById(R.id.normalMap);//普通地图按钮
        button2 = (Button)findViewById(R.id.real);//卫星地图按钮
        baiduMap = mapView.getMap();
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展示普通地图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展示卫星地图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
            }
        });
    }
    //重写以下三个方法，用于管理地图的生命周期
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
