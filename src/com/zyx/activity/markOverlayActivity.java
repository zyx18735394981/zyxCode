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
		//拖动的监听器
		
		baiduMap.setOnMarkerDragListener(mOnMarkerDragListener);
		
		
	}
	/**
	 * 标志拖动的监听器
	 */
	OnMarkerDragListener mOnMarkerDragListener=new OnMarkerDragListener() {
		//开始拖动
		@Override
		public void onMarkerDragStart(Marker marker) {
			
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
		//拖动结束
		@Override
		public void onMarkerDragEnd(Marker marker) {
			
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
		//正在拖动
		@Override
		public void onMarkerDrag(Marker marker) {
			mMapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));

		}
	};
	
	
	OnMarkerClickListener mOnMarkerClickListener=new OnMarkerClickListener() {
		
		@Override
		public boolean onMarkerClick(Marker marker) {
			//单击事件，显示泡泡
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
	
	
	
	//初始化标志
	public void initMarker() {
		MarkerOptions markoptions=new MarkerOptions();
		BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.photo2);
		markoptions.position(new LatLng(37.836934, 112.559513))//位置
		.title("华康大厦")//title
     	.icon(bitmap)	//图标
     	.draggable(true);//设置图标可以拖动
		baiduMap.addOverlay(markoptions);
		
		markoptions=new MarkerOptions().icon(bitmap)
		.position(new LatLng(37.836934-0.01, 112.559513-0.01))
		.title("华康大厦附近")//title
		.draggable(true);
		baiduMap.addOverlay(markoptions);
	}


//抽取成方法
	/**
	 * 创建一个布局参数
	 * @param position
	 * @return
	 */
	private MapViewLayoutParams createLayoutParams(LatLng position){
		 MapViewLayoutParams.Builder builder=new MapViewLayoutParams.Builder();
			builder.layoutMode(ELayoutMode.mapMode);//指定经纬度
			builder.position(position);//设置标志的位置
			//设置偏移量
			builder.yOffset(-40);//往上偏移
			MapViewLayoutParams params=	builder.build();
			return params;
	}
}
