package com.zyx.activity;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;

import com.baidu.mapapi.model.LatLng;


import android.view.KeyEvent;
public class MainActivity extends BaseActivity {


	  @Override
	public void init() {
		
		
	} 
    
    /**
     * ��1,2,3,4,5�л���ͬ��״̬--���û��
     */
	  @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		   MapStatusUpdate mapstatusUpdate=null;
		switch (keyCode) {
		case KeyEvent.KEYCODE_1:
			// 1)��С
		 mapstatusUpdate=MapStatusUpdateFactory.zoomOut();//��С
			   
			break;
		case KeyEvent.KEYCODE_2:
			// 2)�Ŵ�
			 mapstatusUpdate=MapStatusUpdateFactory.zoomIn();//�Ŵ�
			    
				break;
		case KeyEvent.KEYCODE_3:
			// 3)��ת��0 ~ 360����ÿ����ԭ���Ļ���������ת30��
			MapStatus currentMapStatus=baiduMap.getMapStatus();//��ȡ��ǰ��ͼ״̬	
			float rotate=currentMapStatus.rotate+30;//��ԭ���Ļ����ϼ�30��
			System.out.println("rotate="+rotate);
			MapStatus mapstatus=new MapStatus.Builder().rotate(rotate).build();//��ת
			 mapstatusUpdate=MapStatusUpdateFactory.newMapStatus(mapstatus);
			break;
		case KeyEvent.KEYCODE_4:
			 //4)������0 ~ -45����ÿ����ԭ���Ļ������ٸ���-5��
			MapStatus currMapStatus=baiduMap.getMapStatus();//�õ���ǰ��ͼ״̬
			float overlook=currMapStatus.overlook-5;//��ԭ�������Ļ����� -5��
			System.out.println("overlook="+overlook);
			MapStatus mapStatus2=new MapStatus.Builder().overlook(overlook).build();//����
			 mapstatusUpdate=MapStatusUpdateFactory.newMapStatus(mapStatus2);
			break;
		case KeyEvent.KEYCODE_5:
			//5)�ƶ�
			 mapstatusUpdate=MapStatusUpdateFactory.newLatLng(new LatLng(35.894799, 111.439807));//��γ��--�ƶ����б�
		baiduMap.animateMapStatus(mapstatusUpdate, 3000);//��ʾ�ƶ�Ч��
		 return super.onKeyDown(keyCode, event);
	

		
	}
 	 baiduMap.setMapStatus(mapstatusUpdate);//�ı��ͼ״̬
	   return super.onKeyDown(keyCode, event);
}

	
	  

    
}
