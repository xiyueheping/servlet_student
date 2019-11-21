package service.serviceimpl;

import dao.Dao_student;
import dao.daoimpl.Dao_studentimpl;
import domain.Student;
import service.Serv_student;

import java.util.ArrayList;

public class Serv_studentimpl implements Serv_student {
    Dao_student dao_student = new Dao_studentimpl();
    @Override
    //添加一个学生信息
    public String addstu(Student s) {
        String flag;
        String name = s.getName();
        Student student = dao_student.getstudentbyname(name);
        if(student==null){
            boolean b = dao_student.addstudent(s);
            if(b){
                flag = "添加成功";
            }else {
                flag = "添加失败";
            }
        }else {
            flag = "添加失败，姓名已存在";
        }
        return flag;
    }

    @Override
    public String delstu(int id) {
        boolean b = dao_student.delstudent(id);
        if (b==true){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @Override
    public String alterstu(Student s) {
        boolean b = dao_student.alterstudent(s);
        if (b==true){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @Override
    //获取所有学生
    public ArrayList<Student> getall() {
        ArrayList<Student> students = dao_student.getallstudent();
        return students;
    }

    @Override
    //根据name获取一个学生
    public Student getstubyname(String name) {
        Student s = dao_student.getstudentbyname(name);
        return s;
    }
}
