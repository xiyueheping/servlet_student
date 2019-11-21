package dao.daoimpl;
import dao.Dao_user;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DButil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * student表的操作实现类
 */
public class Dao_userimpl implements Dao_user {
    //根据工具类的数据库连接池获取template对象保存在成员变量
    private JdbcTemplate template = new JdbcTemplate(DButil.getDataSource());


    @Override
    public boolean adduser(User s) {
        String sql = "insert into user (username,password) values(?,?)";
        int i = template.update(sql, s.getUsername(),s.getPassword());
        return i>0;
    }

    @Override
    public ArrayList<User> getalluser() {
        String sql3 = "select * from user";
        List<User> studentList = template.query(sql3, new BeanPropertyRowMapper<User>(User.class));
        return (ArrayList<User>)studentList;
    }

    @Override
    public User getuserbyname(String username) {
        String sql = "select * from user where username=?";
        Map<String, Object> map;
        try{
            map = template.queryForMap(sql, username);
            String username2 = (String) map.get("username");
            String password = (String) map.get("password");
            User s = new User(username2,password);
            return s;
        }catch (Exception e){
            return null;
        }
    }
}
