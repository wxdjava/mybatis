package com.wxd.mybatis.pojo;

import java.util.Date;

/**
 * @author wangxuedeng
 * @date 2023/2/9 - 13:23
 */
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Date birth;
    private Character sex;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", date=" + birth +
                ", sex=" + sex +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Date getDate() {
        return birth;
    }

    public void setDate(Date date) {
        this.birth = date;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Student(Long id, String name, Integer age, Double height, Date date, Character sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.birth = date;
        this.sex = sex;
    }

    public Student() {
    }
}
