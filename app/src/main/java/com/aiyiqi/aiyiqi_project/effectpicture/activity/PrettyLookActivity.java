package com.aiyiqi.aiyiqi_project.effectpicture.activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.R;
import com.aiyiqi.aiyiqi_project.effectpicture.entity.Meitu;
import com.facebook.drawee.view.SimpleDraweeView;
import com.finesdk.activity.BaseActivity;
import com.finesdk.imageload.ImageLoader;
import com.finesdk.util.display.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */

public class PrettyLookActivity extends BaseActivity {
    private Fragment fragment_pretty_look;
    private ImageView img_pretty_look_zan,img_pretty_look_zixun,img_pretty_look_share;
    private TextView tv_pretty_look_shengqing,pretty_look_title,pretty_look_tese;
    private Meitu.DataBean.ListBean list;
    private LinearLayout pretty_look_img;
    @Override
    public int getContentViewId() {
        return R.layout.activity_prettylook;
    }

    @Override
    public void beforeInitView() {
        list = (Meitu.DataBean.ListBean) getIntent().getSerializableExtra("list");
    }

    @Override
    public void initView() {
//        fragment_pretty_look = getSupportFragmentManager().findFragmentById(R.id.fragment_pretty_look);
        pretty_look_title = findViewByIdNoCast(R.id.pretty_look_title);
        pretty_look_tese = findViewByIdNoCast(R.id.pretty_look_tese);

        pretty_look_img = findViewByIdNoCast(R.id.pretty_look_img);


        img_pretty_look_zan = findViewByIdNoCast(R.id.img_pretty_look_zan);
        img_pretty_look_zixun = findViewByIdNoCast(R.id.img_pretty_look_zixun);
        img_pretty_look_share = findViewByIdNoCast(R.id.img_pretty_look_share);
        tv_pretty_look_shengqing = findViewByIdNoCast(R.id.tv_pretty_look_shengqing);
    }

    @Override
    public void initData() {
        showData(list);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("list",list);
//        fragment_pretty_look.setArguments(bundle);
    }

    @Override
    public void onClick(View v) {

    }

    public void showData(Meitu.DataBean.ListBean list){
        pretty_look_title.setText(list.getTitle());
        List<String> tag = new ArrayList<>();
        for (int i = 0; i < list.getTag().size(); i++) {
            tag.add(list.getTag().get(i).getName());
            pretty_look_tese.setText("#"+ tag.toString()+" ");
        }

        String url = list.getUrl();
        ImageLoader loader = ImageLoader.getInstance();
        int height = DisplayUtil.getDensity_Height(this);
        SimpleDraweeView img = new SimpleDraweeView(this);
        img.setMaxWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        img.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        img.setMaxHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        img.setMinimumHeight(height/2);
        loader.disPlayImage(img,url);
        pretty_look_img.addView(img);
    }
}
