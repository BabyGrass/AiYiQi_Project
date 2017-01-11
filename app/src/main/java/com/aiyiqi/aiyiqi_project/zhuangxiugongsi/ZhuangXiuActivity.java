package com.aiyiqi.aiyiqi_project.zhuangxiugongsi;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.adapter.ReLvAdapter;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.Data;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.Root;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data.ZxZbData;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.zhuangxiuzhibo_data.ZxZbRoot;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.ConvenientBannerUtil;
import com.finesdk.view.RefreshListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */

public class ZhuangXiuActivity extends BaseActivity{
    //广告轮播的url地址   Get请求
    private static final String GUANGGAO_URL = "http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    //直播装修的url地址 post请求
    private static final String ZHIBO_URL = "http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";

    private ImageView zx_tv_fanhui;//title返回键 （   <   )
    //选中和不选中两张图
    private int[] selects = {R.mipmap.jshop_banner_point_active,R.mipmap.jshop_banner_point_inactive};
    private LinearLayout zx_ll_xinfangzx,zx_ll2_laofangzx;//新房整装的布局id,老房整装的布局id ------》 监听跳转
    private RelativeLayout zx_rl2_kanxianchang,zx_rl2_gongdizhibo,zx_rl2_yiqituandui;//看现场，工地直播，一起团队id
    private List<Data> viewpagerUrl; //viewpager的图片地址集合
    private List<String> convenientBannerUrl;//存放到ConvenientBanner构造方法所需要的数组里；
    private Root root ; //convenientBanner控件的图片数据 json实力类最外层对象
    private ZxZbRoot zxZbRoot;//装修直播的Json数据对象
    private RefreshListView refreshListView;//有头有尾的Listview
    private ReLvAdapter reLvAdapter;//listView的适配器
    private List<OkHttpUtil.Param> params ;//封装POST请求参数的集合


    @Override
    public int getContentViewId() {

        return R.layout.activity_zhuangxiugongsi;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        zx_tv_fanhui = findViewByIdNoCast(R.id.zx_tv_fanhui);
        zx_ll_xinfangzx = findViewByIdNoCast(R.id.zx_ll_xinfangzx);
        zx_ll2_laofangzx = findViewByIdNoCast(R.id.zx_ll2_laofangzx);
        zx_rl2_kanxianchang = findViewByIdNoCast(R.id.zx_rl2_kanxianchang);
        zx_rl2_gongdizhibo = findViewByIdNoCast(R.id.zx_rl2_gongdizhibo);
        zx_rl2_yiqituandui = findViewByIdNoCast(R.id.zx_rl2_yiqituandui);
        refreshListView = findViewByIdNoCast(R.id.zx_listview);
        viewpagerUrl = new ArrayList<>();
        convenientBannerUrl = new ArrayList<>();
        params = setPostParams();

    }



    @Override
    public void initData() {
        setOnClick(zx_tv_fanhui);
        reLvAdapter = new ReLvAdapter(this);
        refreshListView.setAdapter(reLvAdapter);
        refreshListView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
           @Override
           public void onPullRefresh() {
               OkHttpUtil.post(ZHIBO_URL,resultCallback1,params);//直播装修URL，post请求方法
               refreshListView.completeRefresh();//完成重置状态

           }

           @Override
           public void onLoadingMore() {
               OkHttpUtil.post(ZHIBO_URL,resultCallback1,params);//直播装修URL，post请求方法
               refreshListView.completeRefresh();//完成重置状态

           }
       });

        OkHttpUtil.get(GUANGGAO_URL,resultCallback);// 广告轮播URL ，get请求方法
        OkHttpUtil.post(ZHIBO_URL,resultCallback1,params);//直播装修URL，post请求方法
        refreshListView.completeRefresh();//完成重置状态



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zx_tv_fanhui:
                finish();
                break;
        }
    }


    /**
     * Viewpager轮播广告回调接口 Get请求
     */
    OkHttpUtil.ResultCallback resultCallback  = new OkHttpUtil.ResultCallback() {
        @Override
        public void onSuccess(Object response) {

            if(response != null){
                root = new Gson().fromJson(response.toString(),Root.class);
                viewpagerUrl = root.getData();
                for(int i = 0 ; i<viewpagerUrl.size();i++){
                    String url = viewpagerUrl.get(i).imagesrc;//图片1的URL
                    convenientBannerUrl.add(url);//存放到ConvenientBanner构造方法所需要的数组里。
                }
                //将数据传到adapter 在那边用convenientBannerUtil广告工具类生成控件
                reLvAdapter.setFirstItemData(getBaseContext(),convenientBannerUrl,selects);
            }
        }

        @Override
        public void onFailure(Exception e) {

        }
    };

    /**
     * 直播装修的数据接口 Post请求
     */
    OkHttpUtil.ResultCallback resultCallback1= new OkHttpUtil.ResultCallback() {
        @Override
        public void onSuccess(Object response) {

            if(response != null){
                zxZbRoot = new Gson().fromJson(response.toString(),ZxZbRoot.class);
                reLvAdapter.settList(zxZbRoot.getData());
                reLvAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(Exception e) {

        }
    };

    /**
     * 装修直播Post请求参数
     * @return
     */
    public List<OkHttpUtil.Param> setPostParams(){
        List<OkHttpUtil.Param> par = new ArrayList<>();
        OkHttpUtil.Param pams= new OkHttpUtil.Param("token","DAB088BA50C9405E84C789055D657614");
        OkHttpUtil.Param pams1 = new OkHttpUtil.Param("city_id","2");
        OkHttpUtil.Param param2 = new OkHttpUtil.Param("cityName","成都");
        OkHttpUtil.Param param3 = new OkHttpUtil.Param("app_version","android_com.aiyiqi.galaxy_1.1");
        par.add(pams);
        par.add(pams1);
        par.add(param2);
        par.add(param3);
        return par;
    }
}
