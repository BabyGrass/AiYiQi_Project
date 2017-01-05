package com.aiyiqi.aiyiqi_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.assets.ViewPagerImageUrl;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.MainUrlUtils;
import com.aiyiqi.aiyiqi_project.view.SearchActivity;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.ConvenientBannerUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.zxing_image)
    ImageView zxingImage;
    @Bind(R.id.serch_edit)
    EditText serchEdit;
    @Bind(R.id.city_search)
    TextView citySearch;
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
    @Bind(R.id.souye_tv)
    TextView souyeTv;
    @Bind(R.id.yezhusay_tv)
    TextView yezhusayTv;
    @Bind(R.id.msg_tv)
    TextView msgTv;
    @Bind(R.id.mine_tv)
    TextView mineTv;
    private ConvenientBanner convenientBanner;

    //解析数据的类
    private ViewPagerImageUrl viewPagerImageUrl;
    //轮播帮助类
    private ConvenientBannerUtil convenientBannerUtil;
    //点的数组
    private int[] indicators = new int[]{R.mipmap.md_switch_thumb_disable, R.mipmap.md_switch_thumb_off_normal};
    private List<String> imgUrl;

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
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        convenientBanner = findViewByIdNoCast(R.id.first_viewpager_con);
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
                    convenientBannerUtil = new ConvenientBannerUtil(MainActivity.this, convenientBanner, setUrl(), indicators);
                }

            }

            @Override
            public void onFailure(Exception e) {

            }
        }, postParam());
    }

    /**
     * Post请求参数集合
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.zxing_image, R.id.city_search, R.id.decoration_company, R.id.city_actiivty, R.id.decoration_school, R.id.decroation_budget, R.id.catogray_feature, R.id.xiaguo_iamge, R.id.own_order, R.id.design_and_measure, R.id.souye_tv, R.id.yezhusay_tv, R.id.msg_tv, R.id.mine_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zxing_image://二维码
                break;
            case R.id.city_search://城市
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
            case R.id.souye_tv://首页
                break;
            case R.id.yezhusay_tv://业主说
                break;
            case R.id.msg_tv://消息
                break;
            case R.id.mine_tv://我的
                break;
        }
    }

    @OnClick(R.id.serch_edit)//搜索页面
    public void onClick() {
        startActivity(new Intent(this, SearchActivity.class));
    }
}
