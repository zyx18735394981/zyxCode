package com.zyx.activity;


import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

public class markOverlayActivity extends BaseActivity {
	private View pop;
	
	private  TextView tv_title;
	@Override
	public void init() {
		initMarker();
		
		baiduMap.setOnMarkerClickListener(mOnMarkerClickListener);
		//�϶��ļ�����
		
		baiduMap.setOnMarkerDragListener(mOnMarkerDragListener);
		
		
	}
	/**
	 * ��־�϶��ļ�����
	 */
	OnMarkerDragListener mOnMarkerDragListener=new OnMarkerDragListener() {
		//��ʼ�϶�
		@Override
		public void onMarkerDragStart(Marker marker) {
			
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
		//�϶�����
		@Override
		public void onMarkerDragEnd(Marker marker) {
			
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
		//�����϶�
		@Override
		public void onMarkerDrag(Marker marker) {
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
	};
	
	
	OnMarkerClickListener mOnMarkerClickListener=new OnMarkerClickListener() {
		
		@Override
		public boolean onMarkerClick(Marker marker) {
			//�����¼�����ʾ����
			if(pop==null){
		
			 pop=View.inflate(markOverlayActivity.this, R.layout.pop, null);
			
			 tv_title=(TextView)pop.findViewById(R.id.tv_title);
			 
			 mMapView.addView(pop, createLayoutParams(marker.getPosition()));
			}else{
				mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
			}
			tv_title.setText(marker.getTitle());
			return true;
		}
	};
	
	
	
	//��ʼ����־
	public void initMarker() {
		MarkerOptions markoptions=new MarkerOptions();
		BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.photo2);
		markoptions.position(new LatLng(37.836934, 112.559513))//λ��
		.title("��������")//title
     	.icon(bitmap)	//ͼ��
     	.draggable(true);//����ͼ������϶�
		baiduMap.addOverlay(markoptions);
		
		markoptions=new MarkerOptions().icon(bitmap)
		.position(new LatLng(37.836934-0.01, 112.559513-0.01))
		.title("�������ø���")//title
		.draggable(true);
		baiduMap.addOverlay(markoptions);
	}


//��ȡ�ɷ���
	/**
	 * ����һ�����ֲ���
	 * @param position
	 * @return
	 */
	private MapViewLayoutParams createLayoutParams(LatLng position){
		 MapViewLayoutParams.Builder builder=new MapViewLayoutParams.Builder();
			builder.layoutMode(ELayoutMode.mapMode);//ָ����γ��
			builder.position(position);//���ñ�־��λ��
			//����ƫ����
			builder.yOffset(-40);//����ƫ��
			MapViewLayoutParams params=	builder.build();
			return params;
	}
}
