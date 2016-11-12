package com.zyx.activity;


/**
 * 兴趣点--在城市内搜索
 */

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;



public class SearchInCityActivity extends PoiSearchBaseActivity {
	

	/**
	 * 初始化
	 */
	@Override
	public void PoisearchInit() {
		poisearch.searchInCity(getSearchParams());
		
		
	}
	/**
	 * 覆盖父类的方法
	 */
	@Override
	public boolean onPoiClick(int index) {
		//点击搜索出来的搜索点后，在针对该对应的兴趣点 搜索详细的 ---取信息
		PoiInfo poiinfo=poioverlay.getPoiResult().getAllPoi().get(index);
		poisearch.searchPoiDetail(getSearchDeatail(poiinfo.uid));
		return true;
	}
	
	//针对该对应的兴趣点 搜索详细信息
	private PoiDetailSearchOption getSearchDeatail(String poiUid){
		PoiDetailSearchOption params=new PoiDetailSearchOption();
		params.poiUid(poiUid);//针对某一个详细点在进行搜索
			return params;
	}
	//设置第一次搜索的参数
	private PoiCitySearchOption getSearchParams(){
		PoiCitySearchOption params=new PoiCitySearchOption();
		params.city("太原");
		params.keyword("56公交站牌");
		params.pageCapacity(20);//设置一页获取10条数据
		//params.pageNum(pageNum);//指定获取哪一页
		
		return params;
	}
	
	
/**
 * 获取到详情信息的回调方法
 */
	@Override
	public void onGetPoiDetailResult(PoiDetailResult result) {
		if(result==null||result.error!=SearchResult.ERRORNO.NO_ERROR){
			showToast("没有搜索到详情信息");
			return;
		}
		//搜索到--打印结果
		showToast(result.getName()+"=="+result.getAddress()+"=="+result.getTelephone());
		
	}
/**
 * 若想实现分页效果覆盖onkeyDown方法
 */


}
