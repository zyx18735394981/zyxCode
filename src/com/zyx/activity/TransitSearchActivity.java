package com.zyx.activity;

import java.util.List;



import com.baidu.mapapi.overlayutil.TransitRouteOverlay;

import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;

import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.TransitRoutePlanOption.TransitPolicy;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;

public class TransitSearchActivity extends RoutePlanSearchBaseActivity {

	@Override
	public void routePlanSearchInit() {
		roteplanSearch.transitSearch(getSearchParams());

	}
	
	private TransitRoutePlanOption getSearchParams() {
		TransitRoutePlanOption params=new TransitRoutePlanOption();
		//�������
		params.from(PlanNode.withLocation(zhongbei));
		params.city("̫ԭ");//�ĸ�����������
		params.policy(TransitPolicy.EBUS_TIME_FIRST);//����  ʱ������
		//�����յ�
		params.to(PlanNode.withLocation(huakang));
		return params;
	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult arg0) {
		

	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult result) {
	TransitRouteOverlay overlay=new TransitRouteOverlay(baiduMap);
		
		baiduMap.setOnMarkerClickListener(overlay);//ʵ�ֵ����Ӧ
		//����·��  ���ؼ���  ��ȡ�����е�����·��  ���ŵ�·������ǰ��
		List<TransitRouteLine> routeLines = result.getRouteLines();
		//���Ż���·�� ��ȡ��0��
		overlay.setData(routeLines.get(0));//����������õ���������
		overlay.addToMap();//����������ӵ���ͼ��
		overlay.zoomToSpan();//��һ����Ļ����ʾ
		
		

	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult arg0) {
		// TODO Auto-generated method stub

	}



}
