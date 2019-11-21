package dao;

import domain.Student;

import java.util.ArrayList;

public interface Dao_student {
    //添加学生
    public boolean addstudent(Student s);
    //获取所有学生 返回一个list
    public ArrayList<Student> getallstudent();
    //根据name查询学生 返回一个Student对象
    public Student getstudentbyname(String name);
    //根据id删除学生
    public boolean delstudent(int id);
    //根据id修改学生
    public boolean alterstudent(Student s);
}
