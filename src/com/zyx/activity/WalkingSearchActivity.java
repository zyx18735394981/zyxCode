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
 * 步行路线搜索
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
		params.from(PlanNode.withLocation(zhongbei));//起点
		params.to(PlanNode.withLocation(home));//终点
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
		
		baiduMap.setOnMarkerClickListener(overlay);//实现点击响应
		//多条路线  返回集合  获取到所有的搜索路线  最优的路线在最前面
		List<WalkingRouteLine> routeLines = result.getRouteLines();
		//最优化的路线 获取第0条
		overlay.setData(routeLines.get(0));//搜索结果设置到覆盖物上
		overlay.addToMap();//将覆盖物添加到地图上
		overlay.zoomToSpan();//在一个屏幕内显示
		
		

	}

	

}
