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
	 * �����е�Ԫ��
	 */
	private ClassAndName[] datas={
		new ClassAndName(MainActivity.class,"helloBaiduMap"),	//���ص�ͼ�� ����MainActivity����
		new ClassAndName(MapLayerActivity.class,"��ͼͼ��"),
		new ClassAndName(CircleOverlayActivity.class,"Բ�θ�����"),
		new ClassAndName(TextOverlayActivity.class,"���ָ�����"),
		new ClassAndName(markOverlayActivity.class,"mark��־������"),
		new ClassAndName(SearchInBoundActivity.class,"�ڷ�Χ������"),
		new ClassAndName(SearchInCityActivity.class,"�ڳ���������"),
		new ClassAndName(SearchInNearbayActivity.class,"�ڸ�������"),
		new ClassAndName(DrivingSearcherActivity.class,"�ݳ�·������"),
		new ClassAndName(TransitSearchActivity.class,"����·������"),
		new ClassAndName(WalkingSearchActivity.class,"����·������"),
		new ClassAndName(LocationActivity.class,"��λ"),
	};
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		 registerSDKCheckReceiver();
		
		ArrayAdapter<ClassAndName> adapter=new ArrayAdapter<DemoListActivity.ClassAndName>(this, android.R.layout.simple_list_item_1, datas);
		
		setListAdapter(adapter);//��ʾ�б�
		
	}
	
	/**
	 * listview������ҳ��
	 * @author Administrator
	 *
	 */
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//ȡ������λ�õĶ���
	ClassAndName classAndname=(ClassAndName)l.getItemAtPosition(position);
		startActivity(new Intent(this,classAndname.cls));
	}
	
	
	/**
	 * ���ݱ���
	 * @author Administrator
	 *
	 */
	class ClassAndName{
		//���ڱ���Activity���ֽ���
		public Class<?> cls;
		//���ڱ���Activity��Ӧ������
		public String  name;
		public ClassAndName(Class<?> cls, String name) {
			super();
			this.cls = cls;
			this.name = name;
		}
		
		//��name��ʾ��listview��
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
		
	}
	
	
	
    /**
     * ����key�Ƿ���ȷ 
     */
    
    private void registerSDKCheckReceiver(){
    	 receiver=new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				String action=intent.getAction();
				if(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR.equals(action)){
					//�������
					Utils.showToast(DemoListActivity.this,"�������");
				}else if(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR.equals(action)){
					//���key
					Utils.showToast(DemoListActivity.this,"key��֤ʧ��");
				
				}
			}
    		
    	};
    	IntentFilter filter=new IntentFilter();
    	//�����������
    	filter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
    	//����key�Ƿ���ȷ
    	filter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);

    	registerReceiver(receiver, filter);
    	
    }
    
}
