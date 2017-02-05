package com.aiyiqi.aiyiqi_project.myutils;


public interface MySQLiteDatabaseDao {
    void insertData(String uesrName,String password);
    boolean queryData(String userName,String password);//查找(用户名和密码)
    void updateData(String userName,String password);//更新密码
    void deteleData(String uesrName,String password);//根据用户名名字删除
}
