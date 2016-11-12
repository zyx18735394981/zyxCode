package com.zyx.activity;


/**
 * ��Ȥ��--�ڳ���������
 */

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;



public class SearchInCityActivity extends PoiSearchBaseActivity {
	

	/**
	 * ��ʼ��
	 */
	@Override
	public void PoisearchInit() {
		poisearch.searchInCity(getSearchParams());
		
		
	}
	/**
	 * ���Ǹ���ķ���
	 */
	@Override
	public boolean onPoiClick(int index) {
		//������������������������Ըö�Ӧ����Ȥ�� ������ϸ�� ---ȡ��Ϣ
		PoiInfo poiinfo=poioverlay.getPoiResult().getAllPoi().get(index);
		poisearch.searchPoiDetail(getSearchDeatail(poiinfo.uid));
		return true;
	}
	
	//��Ըö�Ӧ����Ȥ�� ������ϸ��Ϣ
	private PoiDetailSearchOption getSearchDeatail(String poiUid){
		PoiDetailSearchOption params=new PoiDetailSearchOption();
		params.poiUid(poiUid);//���ĳһ����ϸ���ڽ�������
			return params;
	}
	//���õ�һ�������Ĳ���
	private PoiCitySearchOption getSearchParams(){
		PoiCitySearchOption params=new PoiCitySearchOption();
		params.city("̫ԭ");
		params.keyword("56����վ��");
		params.pageCapacity(20);//����һҳ��ȡ10������
		//params.pageNum(pageNum);//ָ����ȡ��һҳ
		
		return params;
	}
	
	
/**
 * ��ȡ��������Ϣ�Ļص�����
 */
	@Override
	public void onGetPoiDetailResult(PoiDetailResult result) {
		if(result==null||result.error!=SearchResult.ERRORNO.NO_ERROR){
			showToast("û��������������Ϣ");
			return;
		}
		//������--��ӡ���
		showToast(result.getName()+"=="+result.getAddress()+"=="+result.getTelephone());
		
	}
/**
 * ����ʵ�ַ�ҳЧ������onkeyDown����
 */


}
