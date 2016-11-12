package com.zyx.activity;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
/**
 * 兴趣点--在周边搜索
 * @author Administrator
 *
 */
public class SearchInNearbayActivity extends PoiSearchBaseActivity {

	@Override
	public void PoisearchInit() {
		poisearch.searchNearby(getSearchParams());

	}

	private PoiNearbySearchOption getSearchParams() {
		PoiNearbySearchOption params=new PoiNearbySearchOption();
		params.location(new LatLng(37.836934, 112.559513));//指定在那个位置搜索
		params.radius(1000);//搜索半径，指定搜索范围
		params.keyword("银行");//搜索的内容
		
		return params;
	}

	@Override
	public void onGetPoiDetailResult(PoiDetailResult arg0) {
		// TODO Auto-generated method stub

	}


}
