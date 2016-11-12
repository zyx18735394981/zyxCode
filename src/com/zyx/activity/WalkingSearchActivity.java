package com.zyx.activity;

import java.util.List;

import com.baidu.mapapi.overlayutil.WalkingRouteOverlay;

import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
/**
 * ����·������
 * @author Administrator
 *
 */
public class WalkingSearchActivity extends RoutePlanSearchBaseActivity {

	@Override
	public void routePlanSearchInit() {
		roteplanSearch.walkingSearch(getSearchParams());

	}
	
	private WalkingRoutePlanOption getSearchParams() {
		WalkingRoutePlanOption params=new WalkingRoutePlanOption();
		params.from(PlanNode.withLocation(zhongbei));//���
		params.to(PlanNode.withLocation(home));//�յ�
		return params;
	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult result) {
		WalkingRouteOverlay overlay=new WalkingRouteOverlay(baiduMap);
		
		baiduMap.setOnMarkerClickListener(overlay);//ʵ�ֵ����Ӧ
		//����·��  ���ؼ���  ��ȡ�����е�����·��  ���ŵ�·������ǰ��
		List<WalkingRouteLine> routeLines = result.getRouteLines();
		//���Ż���·�� ��ȡ��0��
		overlay.setData(routeLines.get(0));//����������õ���������
		overlay.addToMap();//����������ӵ���ͼ��
		overlay.zoomToSpan();//��һ����Ļ����ʾ
		
		

	}

	

}
