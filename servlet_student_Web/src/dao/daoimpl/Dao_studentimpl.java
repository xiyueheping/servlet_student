package dao.daoimpl;

import dao.Dao_student;
import domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DButil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dao_studentimpl implements Dao_student {

    //根据工具类的数据库连接池获取template对象保存在成员变量
    private JdbcTemplate template = new JdbcTemplate(DButil.getDataSource());

    @Override
    //新增一个学生
    public boolean addstudent(Student s) {
        String sql = "insert into student (name,sex,age,major,city) values(?,?,?,?,?)";
        int i = template.update(sql, s.getName(), s.getSex(),s.getAge(),s.getMajor(),s.getCity());
        return i>0;
    }

    @Override
    //获取所有学生
    public ArrayList<Student> getallstudent() {
        String sql3 = "select * from student";
        List<Student> studentList = template.query(sql3, new BeanPropertyRowMapper<Student>(Student.class));
        return (ArrayList<Student>)studentList;
    }

    @Override
    //根据name获取一个学生
    public Student getstudentbyname(String sname) {
        String sql = "select * from student where name=?";
        Map<String, Object> map;
        try{
            map = template.queryForMap(sql, sname);
            long id = (Long) map.get("id");
            String name = (String) map.get("name");
            String sex = (String) map.get("sex");
            long age = (Integer) map.get("age");
            String major = (String) map.get("major");
            String city = (String) map.get("city");
            Student s = new Student(id,name,sex,age,major,city);
            return s;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    //根据id删除一个学生
    public boolean delstudent(int id) {
        String sql = "delete from student where id = ?";
        int i = template.update(sql, id);
        return i>0;
    }

    @Override
    //根据id修改一个学生
    public boolean alterstudent(Student s) {
        String sql = "update student set name=?,sex=?,age=?,major=?,city=? where id=?";
        int i = template.update(sql,s.getName(),s.getSex(),s.getAge(),s.getMajor(),s.getCity(),s.getId());
        return i>0;
    }

    public static void main(String[] args) {
        new Dao_studentimpl().getallstudent();
    }
}
