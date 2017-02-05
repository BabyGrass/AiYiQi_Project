package com.aiyiqi.aiyiqi_project.myutils;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.finesdk.util.common.ToastUtil;

public class MySQLiteDatabase implements MySQLiteDatabaseDao{
    private MyHelper mHelper;
    private SQLiteDatabase db;
    public MySQLiteDatabase(){
        mHelper = MyHelper.getInstance();
        db = mHelper.getWritableDatabase();
    }

    /**
     * 插入数据
     * @param userName
     * @param password
     */
    @Override
    public void insertData(String userName, String password) {
        if(isUesrExit(userName)){
            ToastUtil.showToast("用户名已经存在，请直接登录！");
            return;
        }
        ContentValues values = new ContentValues();
        values.put("username",userName);
        values.put("password",password);
        db.insert(MyHelper.LoginCloum.TABLE_NAME,null,values);
    }

    /**
     * 查询数据(登录)
     * @param userName
     * @param password
     */
    @Override
    public boolean queryData(String userName, String password) {
        if(!isUesrExit(userName)){
            ToastUtil.showToast("用户名不存在!");
            return false;
        }
        Cursor c = db.query(MyHelper.LoginCloum.TABLE_NAME,null," where "+ MyHelper.LoginCloum.USER_NAME+" =? and"+
                        MyHelper.LoginCloum.USER_PASSWORD+" =? ",
                new String[]{userName,password},null,null,null);
        if(c == null){
            return false;
        }
        return true;
    }

    /**
     * 更新数据（用于修改找回密码）
     * @param userName
     * @param password
     */
    @Override
    public void updateData(String userName, String password) {
        if(!isUesrExit(userName)){
            ToastUtil.showToast("用户不存在！");
        }
        ContentValues values = new ContentValues();
        values.put("password",password);
        db.update(MyHelper.LoginCloum.TABLE_NAME,values,"select*from "+ MyHelper.LoginCloum.TABLE_NAME+" where "+ MyHelper.LoginCloum.USER_NAME+" =? ",new String[]{userName});
    }

    /**
     * 删除数据
     * @param uesrName
     * @param password
     */
    @Override
    public void deteleData(String uesrName, String password) {

    }

    /**
     * 判断用户是否存在
     */
    public boolean isUesrExit(String uesrName){
       Cursor c =  db.query(MyHelper.LoginCloum.TABLE_NAME,null,"select*from "+ MyHelper.LoginCloum.TABLE_NAME+" where "+ MyHelper.LoginCloum.USER_NAME+" =? ",new String[]{uesrName},null,null,null);
       if(c == null){
           return false;
       }
        return true;
    }


}
