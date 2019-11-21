package service;
import domain.User;

import java.util.ArrayList;
/**
 *  与user有关的业务操作接口
 */
public interface Service_user {
    //完成登陆业务
    public String login(String username,String password);
    //完成注册业务
    public String register(String username,String password);
    //完成查询所有用户业务
    public ArrayList<User> findall();
}
