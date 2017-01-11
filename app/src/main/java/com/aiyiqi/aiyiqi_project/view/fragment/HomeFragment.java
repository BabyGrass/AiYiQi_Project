package com.aiyiqi.aiyiqi_project.view.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.adapter.HomeFragmentListViewAdapter;
import com.aiyiqi.aiyiqi_project.assets.HomeFragmnetResultBean;
import com.aiyiqi.aiyiqi_project.assets.ViewPagerImageUrl;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.MainUrlUtils;
import com.aiyiqi.aiyiqi_project.view.SearchActivity;
import com.aiyiqi.aiyiqi_project.view.detailactivity.ViewPagerDetailActivity;
import com.aiyiqi.aiyiqi_project.view.mianpopupwindow.LocationPopupWindow;
import com.aiyiqi.aiyiqi_project.view.zxing.activity.CaptureActivity;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.finesdk.fragment.BaseFragment;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.ConvenientBannerUtil;
import com.finesdk.util.display.ListViewUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiyiqi.aiyiqi_project.R.id.home_scrollview_footer_relativell;

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.home_scrollview_footer_peogressbar)
    ProgressBar homeScrollviewFooterPeogressbar;
    @Bind(R.id.home_scrollview_footer_textview)
    TextView homeScrollviewFooterTextview;
    @Bind(home_scrollview_footer_relativell)
    RelativeLayout homeScrollviewFooterRelativell;
    private ConvenientBanner firstViewpagerCon;
    //    @Bind(R.id.first_viewpager_con)
    //    ConvenientBanner firstViewpagerCon;
    @Bind(R.id.decoration_company)
    TextView decorationCompany;
    @Bind(R.id.city_actiivty)
    TextView cityActiivty;
    @Bind(R.id.decoration_school)
    TextView decorationSchool;
    @Bind(R.id.decroation_budget)
    TextView decroationBudget;
    @Bind(R.id.catogray_feature)
    TextView catograyFeature;
    @Bind(R.id.xiaguo_iamge)
    TextView xiaguoIamge;
    @Bind(R.id.own_order)
    TextView ownOrder;
    @Bind(R.id.design_and_measure)
    TextView designAndMeasure;
    @Bind(R.id.zxing_image)
    ImageView zxingImage;
    @Bind(R.id.serch_edit)
    EditText serchEdit;
    @Bind(R.id.city_search_ll)
    LinearLayout citySearchLl;
    @Bind(R.id.search_top_background)
    RelativeLayout searchTopBackground;
    @Bind(R.id.search_city_tv)
    TextView searchCityTv;
    //下拉刷新控件
    private SwipeRefreshLayout swipe_refresh;
    //点击回到顶部的图片
    private ImageView homefragment_go_top;
    private ConvenientBanner convenientBanner;
    //解析数据的类
    private ViewPagerImageUrl viewPagerImageUrl;
    //轮播帮助类
    private ConvenientBannerUtil convenientBannerUtil;
    //点的数组
    private int[] indicators = new int[]{R.mipmap.md_switch_thumb_disable, R.mipmap.md_switch_thumb_off_normal};
    private List<String> imgUrl;
    //ListView
    private ListView listView;
    //ScrollView
    private ScrollView homefragment_scrollview;
    private final String TAG = "yiqi";
    //标记上次滑动的位置
    private int scrollY = 0;
    //适配器
    private HomeFragmentListViewAdapter adapter;
    private HomeFragmnetResultBean homeFragmnetResultBean;
    private int index = 0;
    private int page = 1;
    private boolean scrollFlag = false;// 标记是否滑动
    private int lastVisibleItemPosition = 0;// 标记上次滑动位置


    /**
     * 获取轮播图片地址的方法
     *
     * @return
     */
    public List<String> setUrl() {
        imgUrl = new ArrayList<>();
        for (int i = 0; i < viewPagerImageUrl.getData().size(); i++) {
            imgUrl.add(viewPagerImageUrl.getData().get(i).getImagesrc());
        }
        return imgUrl;
    }

    @Override
    protected int getResource() {
        return R.layout.home_fragment_layout;
    }

    @Override
    public void beforeInitView() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView(View rootView) {
        swipe_refresh = findViewByIdNoCast(R.id.swipe_refresh);
        swipe_refresh.setOnRefreshListener(this);
        firstViewpagerCon = findViewByIdNoCast(R.id.first_viewpager_con);
        listView = findViewByIdNoCast(R.id.more_listview);
        convenientBanner = findViewByIdNoCast(R.id.first_viewpager_con);
        homefragment_go_top = findViewByIdNoCast(R.id.homefragment_go_top);
        //点击监听图片回到顶部
        homefragment_go_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homefragment_scrollview.scrollTo(0,0);
            }
        });

        homefragment_scrollview = findViewByIdNoCast(R.id.homefragment_scrollview);
        homefragment_scrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN://按下
                        break;
                    case MotionEvent.ACTION_UP://抬起

                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        View view = ((ScrollView) v).getChildAt(0);
                        if (view.getMeasuredHeight() <= v.getScrollY() + v.getHeight()) {
                            Log.d(TAG,"滑动到底部");
                            page++;
                            downloadImage();
                        }
                        break;
                    default:break;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        downloadImage();
    }


    /**
     * 网络下载轮播图片
     */
    public void downloadImage() {
        OkHttpUtil.post(MainUrlUtils.First_Page, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null) {
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    viewPagerImageUrl = new Gson().fromJson(str, ViewPagerImageUrl.class);
                    convenientBannerUtil = new ConvenientBannerUtil(getActivity(), convenientBanner, setUrl(), indicators);
                    /**
                     * viewpager的点击监听
                     */
                    firstViewpagerCon.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent intent = new Intent(getActivity(), ViewPagerDetailActivity.class);
                            intent.putExtra("viewPagerDetial", viewPagerImageUrl.getData().get(position).getBanner_url());
                            startActivity(intent);
                        }
                    });
                }

            }

            @Override
            public void onFailure(Exception e) {

            }
        }, postParam());

        //        /**
        //         * 网络下载帖子和新闻
        //         */
        OkHttpUtil.post(MainUrlUtils.FIRST_PAGE, new OkHttpUtil.ResultCallback() {
            @Override
            public void onSuccess(Object response) {
                if (response != null) {
                    String str = OkHttpUtil.decodeUnicode(response.toString());
                    homeFragmnetResultBean = new Gson().fromJson(str, HomeFragmnetResultBean.class);
                    adapter = new HomeFragmentListViewAdapter(getActivity(), homeFragmnetResultBean.getData());
                    adapter.addDataThree(homeFragmnetResultBean.getData());
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    ListViewUtil.measureListViewHeight(listView);
                }
            }


            @Override
            public void onFailure(Exception e) {

            }
        }, postTwoParam());

    }

    /**
     * Post请求参数集合(轮播图片)
     */
    public List<OkHttpUtil.Param> postParam() {
        String key1 = "action";
        String value1 = "getownerinfo";
        String key2 = "cityId";
        String value2 = "2";
        List<OkHttpUtil.Param> params = new ArrayList<>();
        OkHttpUtil.Param param = new OkHttpUtil.Param(key1, value1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2, value2);
        params.add(param);
        params.add(param2);
        return params;
    }

    /**
     * 帖子和新闻的参数集合
     *
     * @return
     */
    public List<OkHttpUtil.Param> postTwoParam() {
        String key1 = "page";
        String value1 = page+"";
        String key2 = "pageSize";
        String value2 = "10";
        String key3 = "type";
        String value3 = "3";
        String key4 = "id";
        String value4 = "1218226";
        String key5 = "a";
        String value5 = "appindex";
        String key6 = "m";
        String value6 = "misc";
        List<OkHttpUtil.Param> params = new ArrayList<>();
        OkHttpUtil.Param param1 = new OkHttpUtil.Param(key1, value1);
        OkHttpUtil.Param param2 = new OkHttpUtil.Param(key2, value2);
        OkHttpUtil.Param param3 = new OkHttpUtil.Param(key3, value3);
        OkHttpUtil.Param param4 = new OkHttpUtil.Param(key4, value4);
        OkHttpUtil.Param param5 = new OkHttpUtil.Param(key5, value5);
        OkHttpUtil.Param param6 = new OkHttpUtil.Param(key6, value6);
        params.add(param1);
        params.add(param2);
        params.add(param3);
        params.add(param4);
        params.add(param5);
        params.add(param6);
        return params;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.decoration_company, R.id.city_actiivty, R.id.decoration_school, R.id.decroation_budget, R.id.catogray_feature, R.id.xiaguo_iamge, R.id.own_order, R.id.design_and_measure, R.id.zxing_image, R.id.serch_edit, R.id.city_search_ll, R.id.search_top_background})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zxing_image://二维码
                startActivity(new Intent(getActivity(), CaptureActivity.class));
                break;
            case R.id.serch_edit://搜索
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.city_search_ll://城市
                LocationPopupWindow locationPopupWindow = new LocationPopupWindow(getContext());
                locationPopupWindow.setListView(new LocationPopupWindow.PopupWindowCallBack() {
                    @Override
                    public void onListViewClickCallBack(String string) {
                        if (string == null) {
                            return;
                        }
                        searchCityTv.setText(string);
                    }
                });
                locationPopupWindow.showAsDropDown(citySearchLl);
                break;
            case R.id.decoration_company://装修公司
                break;
            case R.id.city_actiivty://同城活动
                break;
            case R.id.decoration_school://装修学堂
                break;
            case R.id.decroation_budget://装修预算
                break;
            case R.id.catogray_feature://建材家具
                break;
            case R.id.xiaguo_iamge://效果图
                break;
            case R.id.own_order://自助下单
                break;
            case R.id.design_and_measure://设计/测量
                break;
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                swipe_refresh.setRefreshing(false);
            }
        }, 500);
    }

    @OnClick(home_scrollview_footer_relativell)//加载更多
    public void onClick() {

    }
}
