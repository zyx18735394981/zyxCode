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
		
		//List<PlanNode> nodes=new ArrayList<PlanNode>();//设置途经点
		//nodes.add(PlanNode.withCityNameAndPlaceName("山西财经大学","胜利桥东"));
		
			
			params.from(PlanNode.withLocation(zhongbei));//设置起点
			
		//	params.passBy(nodes);//途径点38.009274
			
			params.to(PlanNode.withLocation(home));//设置终点
			
			
			
			return params;
		}

	/**
	 * 获取到驾车搜索结果后回调该方法	
	 */
	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult result) {
		DrivingRouteOverlay overlay=new DrivingRouteOverlay(baiduMap);
		
		baiduMap.setOnMarkerClickListener(overlay);//实现点击响应
		//多条路线  返回集合  获取到所有的搜索路线  最优的路线在最前面
		List<DrivingRouteLine> routeLines = result.getRouteLines();
		//最优化的路线 获取第0条
		overlay.setData(routeLines.get(0));//搜索结果设置到覆盖物上
		overlay.addToMap();//将覆盖物添加到地图上
		overlay.zoomToSpan();//在一个屏幕内显示
		
		

	}
	/**
	 * 获取到换乘搜索结果后回调该方法	
	 */
	@Override
	public void onGetTransitRouteResult(TransitRouteResult result) {
		

	}
	/**
	 * 获取步行搜索结果
	 */
	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult result) {
		

	}



}
