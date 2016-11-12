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
			public final void init() {//��������Ҳ��Ҫ���ʵ�������Է��ڸ����ʼ������������Ͳ���Ҫ��ʼ����
			//ʵ������
			 poisearch=PoiSearch.newInstance();
			//ͨ��ע��һ�������� ��ȡ���صĽ��
			 poisearch.setOnGetPoiSearchResultListener(this);
				
				//���ü��� �õ����ĳ����Ȥ���õ�����Ȥ���Ӧ������
				 poioverlay=new PoiOverlay(baiduMap){
					 
				/**
				 * ������ĵ���¼�	 
				 */
					@Override
			    public boolean onPoiClick(int index) {
				return PoiSearchBaseActivity.this.onPoiClick(index);
					}
				};
				baiduMap.setOnMarkerClickListener(poioverlay);//������������һ������¼�
			PoisearchInit();
			}
			
			
			/**
			 * ���������Ϊ���ú�������า��
			 * @param index
			 * @return
			 */
			public boolean onPoiClick(int index) {
				//�����Ӧ����Ȥ��
				PoiInfo poiinfo=poioverlay.getPoiResult().getAllPoi().get(index);
				//��ӡ���Ƹ���ַ
				showToast(poiinfo.name+"=="+poiinfo.address);
					
					return true;
				}
			
			
			
		 public abstract void PoisearchInit();//poi�����ĳ�ʼ������
		
		//������������Ĵ�������ͬ�ģ����Է��ڸ���
			//��ȡ��Ȥ�����Ϣ
				@Override
				public void onGetPoiResult(PoiResult result) {
					//������
					if(result==null||(result.error)!=SearchResult.ERRORNO.NO_ERROR){
						showToast("û�����������");
						return;
					}
				
					poioverlay.setData(result);//���õ������ݸ���������
					poioverlay.addToMap();//�����е����ݱ�ɸ�������ӵ�baiduMap
					poioverlay.zoomToSpan();//�����еĸ�������һ����Ļ��ʾ����
					
				}
		
		}
