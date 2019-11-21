package service.serviceimpl;
import dao.Dao_user;
import dao.daoimpl.Dao_userimpl;
import domain.User;
import service.Service_user;

import java.util.ArrayList;

/**
 * 与student表有关的业务操作实现类
 */
public class Service_userimpl implements Service_user {
    Dao_user daoUser = new Dao_userimpl();
    @Override
    //登录操作
    public String login(String username,String password) {
        String flag="登录失败，账号不存在";
        //判断账号是否存在
        ArrayList<User> list = daoUser.getalluser();
        for(User s:list){
            //如果存在判断密码是否正确
            if(s.getUsername().equals(username)){
                User u = new Dao_userimpl().getuserbyname(username);
                if(u.getPassword().equals(password)){
                    flag="登录成功";
                }else{
                    flag="登录失败，密码错误";
                }
            }
        }
        return flag;
    }

    @Override
    //注册操作
    public String register(String username,String password) {
        String flag=null;
        //判断账号是否存在
        ArrayList<User> list = daoUser.getalluser();
        for(User s:list){
            //如果存在说明不能注册
            if(s.getUsername().equals(username)){
                flag = "注册失败，账号已存在";
            }
        }
        //如果账号不存在 进行添加用户操作
        if(flag == null){
            User u = new User(username,password);
            new Dao_userimpl().adduser(u);
            flag = "注册成功";
        }
        return flag;
    }

    @Override
    //完成查询所有用户业务
    public ArrayList<User> findall(){
        ArrayList<User> list = daoUser.getalluser();
        return list;
    }
}
