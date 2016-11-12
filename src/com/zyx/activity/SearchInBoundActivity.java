package com.zyx.activity;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;

/**
 * 兴趣点--在周边搜索
 * @author Administrator
 *
 */
public class SearchInBoundActivity extends PoiSearchBaseActivity  {

	

	@Override
	public void PoisearchInit() {
		
	   poisearch.searchInBound(getSearchParams());
	}
	
	private PoiBoundSearchOption getSearchParams(){
		PoiBoundSearchOption params=new PoiBoundSearchOption();
//指定搜索范围。由西南点跟东北点组成
		LatLngBounds bounds=new LatLngBounds.Builder().include(new LatLng(37.836934, 112.559513))
													.include(new LatLng(37.836934+0.1, 112.559513+0.1)).build();
		params.keyword("807公交站牌");//指定搜索什么内容
		params.bound(bounds);//指定搜索范围
		
		return params;
	}
//获取兴趣点的详情信息
	@Override
	public void onGetPoiDetailResult(PoiDetailResult result) {
		// TODO Auto-generated method stub
		
	}


}
