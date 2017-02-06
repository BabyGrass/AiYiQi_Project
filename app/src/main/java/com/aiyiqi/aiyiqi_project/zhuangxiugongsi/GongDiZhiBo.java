package com.aiyiqi.aiyiqi_project.zhuangxiugongsi;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.framework.utils.utils.FirstUrlUtils;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.adapter.GdZbAdapter;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.GdZb_Root;
import com.aiyiqi.aiyiqi_project.zhuangxiugongsi.zhuangxiu_json_data.viewpager_data.gongdizhibo_data.zhuangxiujin_xiangqing.GdZb_ZxJdRoot;
import com.finesdk.activity.BaseActivity;
import com.finesdk.http.OkHttpUtil;
import com.finesdk.util.common.ToastUtil;
import com.finesdk.view.RefreshListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class GongDiZhiBo extends BaseActivity {
    private ImageView zx_iv_fanhui;//返回键
    private TextView zx_tx_title;//抬头
    private RefreshListView gongdizhibo_listview;
    private GdZbAdapter adapter;//适配器
    private GdZb_Root gdZb_root;//工地直播的数据对象（最外层）
    private GdZb_ZxJdRoot gdZb_zxJdRoot;//工地直播装修进度嗮图的数据对象
    private int i;//接收传送过来的数据，来辨别是哪个控件跳转过来的，辨别之后改相应的title
    private String buildingId;//装修直播贴中跳转过来的请求参数， 用于这边网络请求
    private String id;//记录由装修直播图标跳转过来的默认BuildingId
    private int page = 0;//网络请求参数，默认为从下表0开始算起
    @Override
    public int getContentViewId() {
        return R.layout.activity_gongdizhibo;
    }

    @Override
    public void beforeInitView() {
        i = getIntent().getIntExtra("int", 5);//得到传送过来的数据
        buildingId = getIntent().getStringExtra("BuildingId");

    }

    @Override
    public void initView() {
        zx_tx_title = findViewByIdNoCast(R.id.zx_tx_title);
        zx_iv_fanhui = findViewByIdNoCast(R.id.zx_iv_fanhui);
        gongdizhibo_listview = findViewByIdNoCast(R.id.gongdizhibo_listview);
    }

    @Override
    public void initData() {
        adapter = new GdZbAdapter(this);
//
        if (i == 2) {
            zx_tx_title.setText("工地直播");
        }
        if(buildingId != null){
            Log.i("id","buildingId ========="+buildingId);
            OkHttpUtil.post(FirstUrlUtils.BASE_MESSAGE, resultCallback, setHttpParams2());
        }
        gongdizhibo_listview.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onPullRefresh() {
                OkHttpUtil.post(FirstUrlUtils.BASE_MESSAGE, resultCallback, setHttpParams2());
                gongdizhibo_listview.completeRefresh();
            }

            @Override
            public void onLoadingMore() {
               gongdizhibo_listview.completeRefresh();
            }
        });


    }




    @Override
    public void onClick(View v) {

    }

    /**
     * 工地直播 工程信息及人员基本信息
     */

    OkHttpUtil.ResultCallback resultCallback = new OkHttpUtil.ResultCallback() {

        @Override
        public void onSuccess(Object response) {
            gdZb_root = new Gson().fromJson(response.toString(), GdZb_Root.class);
            id = gdZb_root.getData().getBuildingSite().getBuildingId();
            Log.i("heihei","gdZb_root"+gdZb_root.toString());
            adapter.setFirstData(gdZb_root.getData());//将数据传给adapter
            OkHttpUtil.post(FirstUrlUtils.EVALUATE_LIST, resultCallback1, setHttpParams1());

        }

        @Override
        public void onFailure(Exception e) {
            ToastUtil.showToast("网络失败："+e.toString());
        }
    };

    /**
     * 装修进度晒图评价列表
     */
    OkHttpUtil.ResultCallback resultCallback1 = new OkHttpUtil.ResultCallback() {
        @Override
        public void onSuccess(Object response) {
            gdZb_zxJdRoot = new Gson().fromJson(response.toString(),GdZb_ZxJdRoot.class);
            adapter.setGdZb_data(gdZb_zxJdRoot);//传给adapter
            gongdizhibo_listview.setAdapter(adapter);
        }

        @Override
        public void onFailure(Exception e) {
            ToastUtil.showToast("网络失败："+e.toString());
        }
    };




    /**
     * 工地直播Post请求(基本信息,人员及工程进度)参数
     *
     */

    public List<OkHttpUtil.Param> setHttpParams2() {
        List<OkHttpUtil.Param> params1 = new ArrayList<>();
        OkHttpUtil.Param pam = new OkHttpUtil.Param("token", "DC66AA0FC5BE43A7B293845B11D57154");
        OkHttpUtil.Param pam1 = new OkHttpUtil.Param("app_version", "android_com.aiyiqi.galaxy_1.1");
        OkHttpUtil.Param pam2 = new OkHttpUtil.Param("buildingId", buildingId);
        params1.add(pam);
        params1.add(pam1);
        params1.add(pam2);
        return params1;
    }

    /**
     * 装修进度晒图评价列表 请求参数
     */
    public List<OkHttpUtil.Param> setHttpParams1() {
        List<OkHttpUtil.Param> params1 = new ArrayList<>();
        OkHttpUtil.Param pam = new OkHttpUtil.Param("progressId", "1");
        OkHttpUtil.Param pam1 = new OkHttpUtil.Param("app_version", "android_com.aiyiqi.galaxy_1.1");
        OkHttpUtil.Param pam2 = new OkHttpUtil.Param("buildingId",buildingId);
        OkHttpUtil.Param pam3 = new OkHttpUtil.Param("page",page+"");
        OkHttpUtil.Param pam4 = new OkHttpUtil.Param("pageSize", "10");
        params1.add(pam);
        params1.add(pam1);
        params1.add(pam2);
        params1.add(pam3);
        params1.add(pam4);
        return params1;
    }

    /**
     * 装修进度晒图评价列表 请求参数
     *      由装修直播点击图标跳转来  此处buildingId使用基本信息里默认参数的id
     */

    public List<OkHttpUtil.Param> setHttpParams3() {
        List<OkHttpUtil.Param> params1 = new ArrayList<>();
        OkHttpUtil.Param pam = new OkHttpUtil.Param("progressId", "1");
        OkHttpUtil.Param pam1 = new OkHttpUtil.Param("app_version", "android_com.aiyiqi.galaxy_1.1");
        OkHttpUtil.Param pam2 = new OkHttpUtil.Param("buildingId", id);
        OkHttpUtil.Param pam3 = new OkHttpUtil.Param("page", "0");
        OkHttpUtil.Param pam4 = new OkHttpUtil.Param("pageSize", "10");
        params1.add(pam);
        params1.add(pam1);
        params1.add(pam2);
        params1.add(pam3);
        params1.add(pam4);
        return params1;
    }

}