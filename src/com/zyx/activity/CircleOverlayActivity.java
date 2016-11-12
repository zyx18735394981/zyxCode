package com.zyx.activity;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;

public class CircleOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		CircleOptions options=new CircleOptions();//����һ��Բ�θ�����Ĳ���
		//Բ�� 
		options.center(new LatLng(37.836934,112.559513));
		//�뾶 
		options.radius(1000);
		//�������
		options.stroke(new Stroke(20, 0x5500ff00));
		//Բ�������ɫ
		options.fillColor(0x5500ff00);
		
		baiduMap.addOverlay(options);//���һ��������

	}

}
