/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.james.studentapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jamesidowu
 */

@Entity
public class Student {
    
    @Id
    @GeneratedValue
    private Integer studentId;
    private String fName;
    private String lName;
    private int age;
    
    public Student(){}
    
    public Student(Integer id, String fName, String lName, int age){
        this.studentId = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    
    public Student(String fName, String lName, int age){
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        
    }
    

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
   

    @Override
    public String toString() {
        return "Student{" + "Student Id=" + studentId + 
                ", First Name=" + fName + 
                ", last Name=" + lName + 
                ", Age=" + age + 
                '}';
    }
    
    
}
