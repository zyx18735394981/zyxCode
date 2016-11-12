package com.zyx.activity;

import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.RoutePlanSearch;

public abstract class RoutePlanSearchBaseActivity extends BaseActivity implements OnGetRoutePlanResultListener {

	protected RoutePlanSearch roteplanSearch;

	@Override
	public void init() {
		roteplanSearch = RoutePlanSearch.newInstance();
		
		roteplanSearch.setOnGetRoutePlanResultListener(this);
		
		routePlanSearchInit();
	}
	/**
	 * ·�������ĳ�ʼ������
	 */
	public abstract void routePlanSearchInit();

}
