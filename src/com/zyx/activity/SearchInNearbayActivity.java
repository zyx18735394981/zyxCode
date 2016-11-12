package com.zyx.activity;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
/**
 * ��Ȥ��--���ܱ�����
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
		params.location(new LatLng(37.836934, 112.559513));//ָ�����Ǹ�λ������
		params.radius(1000);//�����뾶��ָ��������Χ
		params.keyword("����");//����������
		
		return params;
	}

	@Override
	public void onGetPoiDetailResult(PoiDetailResult arg0) {
		// TODO Auto-generated method stub

	}


}
