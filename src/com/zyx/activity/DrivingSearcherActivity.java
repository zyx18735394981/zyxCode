package com.zyx.activity;


import java.util.List;


import com.baidu.mapapi.overlayutil.DrivingRouteOverlay;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;

public class DrivingSearcherActivity extends RoutePlanSearchBaseActivity {
		@Override
		public void routePlanSearchInit() {
			roteplanSearch.drivingSearch(getSearchParams());
			
		}
		
	private DrivingRoutePlanOption getSearchParams() {
		DrivingRoutePlanOption params=new DrivingRoutePlanOption();
		
		//List<PlanNode> nodes=new ArrayList<PlanNode>();//����;����
		//nodes.add(PlanNode.withCityNameAndPlaceName("ɽ���ƾ���ѧ","ʤ���Ŷ�"));
		
			
			params.from(PlanNode.withLocation(zhongbei));//�������
			
		//	params.passBy(nodes);//;����38.009274
			
			params.to(PlanNode.withLocation(home));//�����յ�
			
			
			
			return params;
		}

	/**
	 * ��ȡ���ݳ����������ص��÷���	
	 */
	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult result) {
		DrivingRouteOverlay overlay=new DrivingRouteOverlay(baiduMap);
		
		baiduMap.setOnMarkerClickListener(overlay);//ʵ�ֵ����Ӧ
		//����·��  ���ؼ���  ��ȡ�����е�����·��  ���ŵ�·������ǰ��
		List<DrivingRouteLine> routeLines = result.getRouteLines();
		//���Ż���·�� ��ȡ��0��
		overlay.setData(routeLines.get(0));//����������õ���������
		overlay.addToMap();//����������ӵ���ͼ��
		overlay.zoomToSpan();//��һ����Ļ����ʾ
		
		

	}
	/**
	 * ��ȡ���������������ص��÷���	
	 */
	@Override
	public void onGetTransitRouteResult(TransitRouteResult result) {
		

	}
	/**
	 * ��ȡ�����������
	 */
	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult result) {
		

	}



}
