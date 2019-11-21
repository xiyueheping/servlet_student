package dao;

import domain.User;

import java.util.ArrayList;

/**
 * user表的操作接口标准
 */
public interface Dao_user {
    //添加用户
    public boolean adduser(User s);
    //获取所有用户 返回一个list
    public ArrayList<User> getalluser();
    //根据账号查询用户 返回一个user对象
    public User getuserbyname(String name);
}
