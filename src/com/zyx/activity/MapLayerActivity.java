package com.zyx.activity;

import android.view.KeyEvent;
/**
 * 地图图层
 * @author Administrator
 *
 */
public class MapLayerActivity extends BaseActivity {

	@Override
	public void init() {
		

	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_1:
			//普通地图
			baiduMap.setMapType(baiduMap.MAP_TYPE_NORMAL);
			baiduMap.setTrafficEnabled(false);//不显示交通图
			
			break;
	   case KeyEvent.KEYCODE_2:
		   //卫星图
		   baiduMap.setMapType(baiduMap.MAP_TYPE_SATELLITE);
		   baiduMap.setTrafficEnabled(false);
			
			break;
		   case KeyEvent.KEYCODE_3:
			//交通图
			baiduMap.setTrafficEnabled(true);
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

}
