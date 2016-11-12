package com.zyx.activity;


import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

import com.baidu.mapapi.model.LatLng;
import com.zyx.activity.util.Utils;

import android.app.Activity;
import android.os.Bundle;


public abstract class BaseActivity extends Activity {
	protected MapView mMapView;
	protected  BaiduMap baiduMap;
	private double weidu=37.836934;
	private double jingdu=112.559513;
	
	protected LatLng zhongbei=new LatLng(38.015895, 112.448364);
	protected LatLng huakang=new LatLng(37.836934, 112.559513);
	protected LatLng home=new LatLng(35.889040, 111.433749);

	//��final��Ϊ�˲������า��  ԭ����Ԥ�������һЩ�໹û��ʼ���ͱ��������
	@Override
	protected final void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_main);
	        //��ȡ��ͼ�ؼ�
	        mMapView=(MapView)findViewById(R.id.bmapView);//������ʾ   
	        //��ȡ��ͼ�Ŀ�����
	       baiduMap=mMapView.getMap();//���ڿ���
	       
	       //1.�������Ű�ť��������
	     //  mMapView.showScaleControl(false);//���ر����ߣ�Ĭ����ʾ
	     //  mMapView.showZoomControls(false);//�������Ű�ť��Ĭ����ʾ
	   
	      // 2.��ȡ��ȡ��С��3����������ż���20��
	      float maxZoomLevel=baiduMap.getMaxZoomLevel();//	��ȡ��ͼ������ż���
	      float minZoomLevel=baiduMap.getMinZoomLevel();//	��ȡ��ͼ��С���ż���
	      System.out.println("max="+maxZoomLevel+"min="+minZoomLevel);//20  3.0
	      
	      // 3.���õ�ͼ���ĵ�Ϊ̫ԭ-��������   MapStatusUpdateû�й��췽��  �ù���������   γ��37.836934  ����112.559513
	      MapStatusUpdate mapstatusUpdate=MapStatusUpdateFactory.newLatLng(new LatLng(weidu, jingdu));
	       baiduMap.setMapStatus(mapstatusUpdate);//�ı��ͼ״̬
	     
	       // 4.���õ�ͼ����Ϊ15
	       mapstatusUpdate= MapStatusUpdateFactory.zoomTo(15);//����
	       baiduMap.setMapStatus(mapstatusUpdate);//�ı��ͼ״̬
	       
	       //5.��ȡ��ͼui����  ָ����
	      /* UiSettings uiSettings=baiduMap.getUiSettings();
	       uiSettings.setCompassEnabled(false);//����ָ����
*/	       
	      //������ȥʵ��
	       init();
	}
	
	/**
	 * ������ʵ��
	 */
	public abstract void init();
	
	/**
	 * ����Ļ������ʾһ��Toast
	 * @param text
	 */
	public void showToast(CharSequence text){
		Utils.showToast(this,text);
	}
	
 
	    @Override  
	    protected void onResume() {  
	        super.onResume();  
	        //��activityִ��onResumeʱִ��mMapView. onResume ()��ʵ�ֵ�ͼ�������ڹ���  
	        mMapView.onResume();  
	        }  
	    @Override  
	    protected void onPause() {  
	        super.onPause();  
	        //��activityִ��onPauseʱִ��mMapView. onPause ()��ʵ�ֵ�ͼ�������ڹ���  
	        mMapView.onPause();  
	        }
     @Override  
	    protected void onDestroy() {  
	        super.onDestroy();  
	        mMapView.onDestroy();  
	    
	    }  

	    

}
