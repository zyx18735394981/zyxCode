package com.zyx.activity;

import com.baidu.mapapi.SDKInitializer;
import com.zyx.activity.util.Utils;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DemoListActivity extends ListActivity {
	private BroadcastReceiver receiver;
	/**
	 * 数组中的元素
	 */
	private ClassAndName[] datas={
		new ClassAndName(MainActivity.class,"helloBaiduMap"),	//加载地图了 加载MainActivity类了
		new ClassAndName(MapLayerActivity.class,"地图图层"),
		new ClassAndName(CircleOverlayActivity.class,"圆形覆盖物"),
		new ClassAndName(TextOverlayActivity.class,"文字覆盖物"),
		new ClassAndName(markOverlayActivity.class,"mark标志覆盖物"),
		new ClassAndName(SearchInBoundActivity.class,"在范围内搜索"),
		new ClassAndName(SearchInCityActivity.class,"在城市内搜索"),
		new ClassAndName(SearchInNearbayActivity.class,"在附近搜索"),
		new ClassAndName(DrivingSearcherActivity.class,"驾车路线搜索"),
		new ClassAndName(TransitSearchActivity.class,"换乘路线搜索"),
		new ClassAndName(WalkingSearchActivity.class,"步行路线搜索"),
		new ClassAndName(LocationActivity.class,"定位"),
	};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		 registerSDKCheckReceiver();
		
		ArrayAdapter<ClassAndName> adapter=new ArrayAdapter<DemoListActivity.ClassAndName>(this, android.R.layout.simple_list_item_1, datas);
		
		setListAdapter(adapter);//显示列表
		
	}
	
	/**
	 * listview点击项打开页面
	 * @author Administrator
	 *
	 */
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//取出单击位置的对象
	ClassAndName classAndname=(ClassAndName)l.getItemAtPosition(position);
		startActivity(new Intent(this,classAndname.cls));
	}
	
	
	/**
	 * 数据保存
	 * @author Administrator
	 *
	 */
	class ClassAndName{
		//用于保存Activity的字节码
		public Class<?> cls;
		//用于保存Activity对应的名字
		public String  name;
		public ClassAndName(Class<?> cls, String name) {
			super();
			this.cls = cls;
			this.name = name;
		}
		
		//将name显示在listview上
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
		
	}
	
	
	
    /**
     * 监听key是否正确 
     */
    
    private void registerSDKCheckReceiver(){
    	 receiver=new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				String action=intent.getAction();
				if(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR.equals(action)){
					//网络错误
					Utils.showToast(DemoListActivity.this,"网络错误");
				}else if(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR.equals(action)){
					//检测key
					Utils.showToast(DemoListActivity.this,"key验证失败");
				
				}
			}
    		
    	};
    	IntentFilter filter=new IntentFilter();
    	//监听网络错误
    	filter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
    	//监听key是否正确
    	filter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);

    	registerReceiver(receiver, filter);
    	
    }
    
}
