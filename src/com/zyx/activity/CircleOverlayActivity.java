package com.zyx.activity;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;

public class CircleOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		CircleOptions options=new CircleOptions();//创建一个圆形覆盖物的参数
		//圆心 
		options.center(new LatLng(37.836934,112.559513));
		//半径 
		options.radius(1000);
		//线条宽度
		options.stroke(new Stroke(20, 0x5500ff00));
		//圆的填充颜色
		options.fillColor(0x5500ff00);
		
		baiduMap.addOverlay(options);//添加一个覆盖物

	}

}
