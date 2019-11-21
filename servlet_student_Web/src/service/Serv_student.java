package service;

import domain.Student;

import java.util.ArrayList;

public interface Serv_student {
    //新增一个学生
    public String addstu(Student s);
    //根据id删除一个学生
    public String delstu(int id);
    //修改一个学生
    public String alterstu(Student s);
    //查询所有学生
    public ArrayList<Student> getall();
    //根据name查询一个学生信息
    public Student getstubyname(String name);
}