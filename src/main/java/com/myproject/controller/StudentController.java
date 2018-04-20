package com.myproject.controller;

import com.myproject.entity.Student;
import com.myproject.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
//    @Autowired
//    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

  /*  @PostMapping("/find")
    public String findByUid(@RequestParam("uid") int uid){
        Student student = studentService.findByUid(uid);
        if(student!=null) {
            return student.toString();
        } else {
            return "Can not find uid : "+uid;
        }
    }*/

    @GetMapping("/findall")
    public @ResponseBody  Iterable<Student> findAll(){
        return studentRepository.findAll();
    }
    @PostMapping("/findbyname")
    public @ResponseBody
    List<Student> findByUname(@RequestParam("uname") String uname){
        return studentRepository.findByUname(uname);
    }
    @PutMapping("add")
    public @ResponseBody  Student save(@RequestParam("uname") String uname,
                                       @RequestParam("sex")  int sex){
        Student student = new Student();
        student.setSex(sex);
        student.setUname(uname);
        return studentRepository.save(student);
    }
}
