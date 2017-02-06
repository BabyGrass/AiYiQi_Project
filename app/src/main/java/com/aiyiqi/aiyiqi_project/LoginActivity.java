package com.aiyiqi.aiyiqi_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiyiqi.aiyiqi_project.myutils.MySQLiteDatabase;
import com.finesdk.activity.BaseActivity;
import com.finesdk.util.common.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/1/8.
 */

public class LoginActivity extends BaseActivity {
    @Bind(R.id.login_cancle)
    TextView loginCancle;
    @Bind(R.id.uesr_name_et)
    EditText uesrNameEt;
    @Bind(R.id.user_password_et)
    EditText userPasswordEt;
    @Bind(R.id.password_lock)
    ImageView passwordLock;
    @Bind(R.id.msg_quick_login)
    TextView msgQuickLogin;
    @Bind(R.id.forget_password)
    TextView forgetPassword;
    @Bind(R.id.login_registor_button)
    Button loginRegistorButton;
    private TextView login_cancle;

    private String et_name,et_password;
    //数据库
    private MySQLiteDatabase mySQLiteDatabase;


    @Override
    public int getContentViewId() {
        return R.layout.login_activity_layout;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mySQLiteDatabase = new MySQLiteDatabase();


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_cancle, R.id.uesr_name_et, R.id.user_password_et, R.id.password_lock, R.id.msg_quick_login, R.id.forget_password, R.id.login_registor_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_cancle:
                this.finish();
                break;
            case R.id.uesr_name_et://用户名
                break;
            case R.id.user_password_et://密码
                break;
            case R.id.password_lock://密码可见与隐蔽
                break;
            case R.id.msg_quick_login://短信登录
                break;
            case R.id.forget_password://忘记密码
                break;
            case R.id.login_registor_button://登录注册
                et_name = uesrNameEt.getText().toString();
                et_password = userPasswordEt.getText().toString();
                if(et_name.equals("") || et_name == null){
                    uesrNameEt.setError("用户名不能为空！");
                }
                if(et_password.equals("") || et_password == null){
                    userPasswordEt.setError("密码不能为空！");
                }
                if(mySQLiteDatabase.isUesrExit(et_name)){//用户存在
                    mySQLiteDatabase.queryData(et_name,et_password);
                    ToastUtil.showToast("登陆成功!");
                }
                else{
                    mySQLiteDatabase.insertData(et_name,et_password);
                }
                break;
        }
    }
}
