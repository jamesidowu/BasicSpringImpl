/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.james.studentapp.controllers;

import com.james.studentapp.repositories.StudentRepository;
import com.james.studentapp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jamesidowu
 */

@Controller
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepo;
    
    @GetMapping("/studentmanagement")
    public String showStudentManagement(Model model, Student student){
         model.addAttribute("students", studentRepo.findAll());
         model.addAttribute("count", studentRepo.count());
        return "student-management";
    }
    
    @GetMapping("/addstudentform")
    public String showAddStudentForm(Student student){
        
        return "add-student"; 
    }
    
    @PostMapping("/addstudentform")
    public String addStudent(Student student, Model model){
         if (student.getAge() < 18){
             return"add-student";
         }
        studentRepo.save(student);
//        model.addAttribute("students", studentRepo.findAll());
        return "redirect:/studentmanagement";
    }
    
 
    @GetMapping("/delete")
    public String deleteStudent(Integer id) {
       studentRepo.deleteById(id);
        
        return "redirect:/studentmanagement";
    } 
    
    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model) {
    model.addAttribute("student", studentRepo.findById(id));
    
    return "update-student";
    }
    
    @PostMapping("/edit")
    public String saveUpdate(Student student, Model model) {
       studentRepo.findById(student.getStudentId());
       studentRepo.save(student);
    return "redirect:/studentmanagement";
    }
   
}
