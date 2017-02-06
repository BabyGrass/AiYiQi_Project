package com.aiyiqi.aiyiqi_project.view.mianpopupwindow;


import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.aiyiqi.aiyiqi_project.R;

import java.util.ArrayList;
import java.util.List;

public class LocationPopupWindow extends PopupWindow{
    private ListView listView;
    private String [] datas = {"GPS定位城市","北京","已经开通服务的城市","北京","上海","天津","石家庄"
    ,"西安","武汉","成都","哈尔滨","大连","济南"};
    private List<String> list = null;
    private ArrayAdapter arrayAdapter;
    public LocationPopupWindow(Context context){
        super(context);
        View view = View.inflate(context, R.layout.location_popupwindow_layout,null);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.setBackgroundDrawable(new BitmapDrawable());
        initView(view,context);
    }

    public void initView(View view,Context context){
        listView = (ListView) view.findViewById(R.id.location_listview);
        arrayAdapter = new ArrayAdapter(context,R.layout.popupwindow_textview_layout,getData());
        listView.setAdapter(arrayAdapter);
    }
    /**
     * 监听回调显示数据
     */
    public void setListView(final PopupWindowCallBack callBack){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(callBack != null){
                    callBack.onListViewClickCallBack(list.get(position));
                    dismiss();
                }
            }
        });
    }


    /**
     * ListView获取数据的方法
     */
    public List<String> getData(){
        list = new ArrayList<>();
        for(int i =0;i<datas.length;i++){
            list.add(datas[i]);
        }
        return list;
    }

    /**
     * 点击监听回调
     */
    public interface PopupWindowCallBack{
        void onListViewClickCallBack(String string);
    }
}
