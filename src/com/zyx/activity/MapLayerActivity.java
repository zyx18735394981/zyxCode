package com.zyx.activity;

import android.view.KeyEvent;
/**
 * ��ͼͼ��
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
			//��ͨ��ͼ
			baiduMap.setMapType(baiduMap.MAP_TYPE_NORMAL);
			baiduMap.setTrafficEnabled(false);//����ʾ��ͨͼ
			
			break;
	   case KeyEvent.KEYCODE_2:
		   //����ͼ
		   baiduMap.setMapType(baiduMap.MAP_TYPE_SATELLITE);
		   baiduMap.setTrafficEnabled(false);
			
			break;
		   case KeyEvent.KEYCODE_3:
			//��ͨͼ
			baiduMap.setTrafficEnabled(true);
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

}
