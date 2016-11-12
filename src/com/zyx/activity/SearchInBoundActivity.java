package com.zyx.activity;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;

/**
 * ��Ȥ��--���ܱ�����
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
//ָ��������Χ�������ϵ�����������
		LatLngBounds bounds=new LatLngBounds.Builder().include(new LatLng(37.836934, 112.559513))
													.include(new LatLng(37.836934+0.1, 112.559513+0.1)).build();
		params.keyword("807����վ��");//ָ������ʲô����
		params.bound(bounds);//ָ��������Χ
		
		return params;
	}
//��ȡ��Ȥ���������Ϣ
	@Override
	public void onGetPoiDetailResult(PoiDetailResult result) {
		// TODO Auto-generated method stub
		
	}


}
