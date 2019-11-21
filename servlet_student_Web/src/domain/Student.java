package domain;

import java.util.Objects;

public class Student {
    private long id;
    private String name;
    private String sex;
    private long age;
    private String major;
    private String city;
    public Student(){}
    public Student(String name, String sex, long age, String major, String city) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.city = city;
    }
    public Student(long id, String name, String sex, long age, String major, String city) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(major, student.major) &&
                Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, major, city);
    }
}
