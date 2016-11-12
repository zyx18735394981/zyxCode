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
		//设置起点
		params.from(PlanNode.withLocation(zhongbei));
		params.city("太原");//哪个城市内搜索
		params.policy(TransitPolicy.EBUS_TIME_FIRST);//策略  时间优先
		//设置终点
		params.to(PlanNode.withLocation(huakang));
		return params;
	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult arg0) {
		

	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult result) {
	TransitRouteOverlay overlay=new TransitRouteOverlay(baiduMap);
		
		baiduMap.setOnMarkerClickListener(overlay);//实现点击响应
		//多条路线  返回集合  获取到所有的搜索路线  最优的路线在最前面
		List<TransitRouteLine> routeLines = result.getRouteLines();
		//最优化的路线 获取第0条
		overlay.setData(routeLines.get(0));//搜索结果设置到覆盖物上
		overlay.addToMap();//将覆盖物添加到地图上
		overlay.zoomToSpan();//在一个屏幕内显示
		
		

	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult arg0) {
		// TODO Auto-generated method stub

	}



}
