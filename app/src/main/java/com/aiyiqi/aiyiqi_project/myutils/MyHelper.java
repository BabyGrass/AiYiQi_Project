package com.aiyiqi.aiyiqi_project.myutils;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aiyiqi.aiyiqi_project.MyApplication;

public class MyHelper extends SQLiteOpenHelper {
    private static MyHelper myHelper;

    private static final int VERSION = 1;
    private static final String DB_NAME = "login_db";

    public MyHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    /**
     * 单例设计模式
     */
    public static MyHelper getInstance(){
        if(myHelper == null){
            myHelper = new MyHelper(MyApplication.newInstance().getApplicationContext());
        }
        return myHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+LoginCloum.TABLE_NAME+"("+LoginCloum.ID+" Integer primary key autoincrement,"
                +LoginCloum.USER_NAME+" text,"+LoginCloum.USER_PASSWORD+" text,"+LoginCloum.USER_MSG+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**
         * 更新版本
         */
        if(oldVersion == 1 && newVersion == 2){
            db.execSQL("alter table login_table add column sex text");//新增一个字段
        }
        else if(oldVersion == 1 && newVersion == 3){
            db.execSQL("alter table login_table add column sex text");//新增一个字段
            db.execSQL("create table test(_id integer primary key autoincrement,content text)");//新增一个表
        }
        else if(oldVersion == 2 && newVersion ==3){
            db.execSQL("create table test(_id integer primary key autoincrement,content text)");//新增一个表
        }
    }

    /**
     * 版本降级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public interface LoginCloum{
        String TABLE_NAME = "login_table";
        String ID = "_id";
        String USER_NAME = "username";
        String USER_PASSWORD = "userpassword";
        String USER_MSG = "ueer_msg";
    }

}

