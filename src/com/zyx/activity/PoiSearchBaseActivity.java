package com.zyx.activity;
		
import com.baidu.mapapi.overlayutil.PoiOverlay;
		import com.baidu.mapapi.search.core.PoiInfo;
		import com.baidu.mapapi.search.core.SearchResult;
		import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
		import com.baidu.mapapi.search.poi.PoiResult;
		import com.baidu.mapapi.search.poi.PoiSearch;
		
		public abstract class PoiSearchBaseActivity extends BaseActivity implements OnGetPoiSearchResultListener{
			protected PoiSearch poisearch;
			protected PoiOverlay poioverlay;
			@Override
			public final void init() {//其他搜索也需要这个实例，所以放在父类初始化，这样子类就不需要初始化了
			//实例化类
			 poisearch=PoiSearch.newInstance();
			//通过注册一个监听器 获取返回的结果
			 poisearch.setOnGetPoiSearchResultListener(this);
				
				//设置监听 得到点击某个兴趣点后得到该兴趣点对应的数据
				 poioverlay=new PoiOverlay(baiduMap){
					 
				/**
				 * 覆盖物的点击事件	 
				 */
					@Override
			    public boolean onPoiClick(int index) {
				return PoiSearchBaseActivity.this.onPoiClick(index);
					}
				};
				baiduMap.setOnMarkerClickListener(poioverlay);//给覆盖物设置一个点击事件
			PoisearchInit();
			}
			
			
			/**
			 * 这个方法是为了让后面的子类覆盖
			 * @param index
			 * @return
			 */
			public boolean onPoiClick(int index) {
				//点击对应的兴趣点
				PoiInfo poiinfo=poioverlay.getPoiResult().getAllPoi().get(index);
				//打印名称跟地址
				showToast(poiinfo.name+"=="+poiinfo.address);
					
					return true;
				}
			
			
			
		 public abstract void PoisearchInit();//poi搜索的初始化代码
		
		//其他搜索结果的处理都是相同的，所以放在父类
			//获取兴趣点的信息
				@Override
				public void onGetPoiResult(PoiResult result) {
					//错误码
					if(result==null||(result.error)!=SearchResult.ERRORNO.NO_ERROR){
						showToast("没有搜索到结果");
						return;
					}
				
					poioverlay.setData(result);//将得到的数据赋给覆盖物
					poioverlay.addToMap();//把所有的数据变成覆盖物添加到baiduMap
					poioverlay.zoomToSpan();//把所有的覆盖物在一个屏幕显示出来
					
				}
		
		}
