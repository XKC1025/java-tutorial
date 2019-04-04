package com.xkc.learn.mybatis.domain;

import java.util.Date;

public class EmpModel {
    private Integer id;
    private String name;
    private String gender;
    private Double salary;
    private Date join_date;
    private Integer dept_id;

    public EmpModel() {
    }

    public EmpModel(String name, String gender, Double salary, Date join_date, Integer dept_id) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.join_date = join_date;
        this.dept_id = dept_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "EmpModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", join_date=" + join_date +
                ", dept_id=" + dept_id +
                '}';
    }
}
