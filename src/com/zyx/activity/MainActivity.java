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
     * 按1,2,3,4,5切换不同的状态--真机没用
     */
	  @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		   MapStatusUpdate mapstatusUpdate=null;
		switch (keyCode) {
		case KeyEvent.KEYCODE_1:
			// 1)缩小
		 mapstatusUpdate=MapStatusUpdateFactory.zoomOut();//缩小
			   
			break;
		case KeyEvent.KEYCODE_2:
			// 2)放大
			 mapstatusUpdate=MapStatusUpdateFactory.zoomIn();//放大
			    
				break;
		case KeyEvent.KEYCODE_3:
			// 3)旋转（0 ~ 360），每次在原来的基础上再旋转30度
			MapStatus currentMapStatus=baiduMap.getMapStatus();//获取当前地图状态	
			float rotate=currentMapStatus.rotate+30;//在原来的基础上加30度
			System.out.println("rotate="+rotate);
			MapStatus mapstatus=new MapStatus.Builder().rotate(rotate).build();//旋转
			 mapstatusUpdate=MapStatusUpdateFactory.newMapStatus(mapstatus);
			break;
		case KeyEvent.KEYCODE_4:
			 //4)俯仰（0 ~ -45），每次在原来的基础上再俯仰-5度
			MapStatus currMapStatus=baiduMap.getMapStatus();//得到当前地图状态
			float overlook=currMapStatus.overlook-5;//在原来俯仰的基础上 -5度
			System.out.println("overlook="+overlook);
			MapStatus mapStatus2=new MapStatus.Builder().overlook(overlook).build();//俯仰
			 mapstatusUpdate=MapStatusUpdateFactory.newMapStatus(mapStatus2);
			break;
		case KeyEvent.KEYCODE_5:
			//5)移动
			 mapstatusUpdate=MapStatusUpdateFactory.newLatLng(new LatLng(35.894799, 111.439807));//经纬度--移动到中北
		baiduMap.animateMapStatus(mapstatusUpdate, 3000);//显示移动效果
		 return super.onKeyDown(keyCode, event);
	

		
	}
 	 baiduMap.setMapStatus(mapstatusUpdate);//改变地图状态
	   return super.onKeyDown(keyCode, event);
}

	
	  

    
}
