package com.zyx.activity;

import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;

public class TextOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		TextOptions textoptions=new TextOptions();
		//位置
		textoptions.position(new LatLng(37.836934, 112.559513))
		.text("张祎欣") //文字内容
		.fontSize(30)//	//文字大小
         .fontColor(0xff000000) //文字颜色
		.bgColor(0x55ff0000)//背景颜色
		.rotate(30);	//旋转
		baiduMap.addOverlay(textoptions);
		

	}

}
