package com.zyx.activity;

import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;

public class TextOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		TextOptions textoptions=new TextOptions();
		//λ��
		textoptions.position(new LatLng(37.836934, 112.559513))
		.text("�ŵt��") //��������
		.fontSize(30)//	//���ִ�С
         .fontColor(0xff000000) //������ɫ
		.bgColor(0x55ff0000)//������ɫ
		.rotate(30);	//��ת
		baiduMap.addOverlay(textoptions);
		

	}

}
