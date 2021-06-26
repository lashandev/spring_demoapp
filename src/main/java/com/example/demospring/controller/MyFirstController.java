package com.example.demospring.controller;

import com.example.demospring.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "first")
public class MyFirstController {
    @GetMapping(value = "/getname")
    public String getName(){
        return "Lashan Chandika";
    }

    @GetMapping(value = "/checkparam")
    public String checkParam(@RequestParam(name = "myname") String myname){
        String text = "My name is : "+myname;
        return text;
    }

    @PostMapping(value = "/getfullname")
    public String getFullName(@RequestParam(name = "fname") String fname,
                              @RequestParam(name = "lname", required = false) String lname){

        String fullname = fname + " " + lname;
        return fullname;
    }

    @GetMapping(value = "/testpathvariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") int id){
        String text = "ID :"+id;
        return text;
    }

    @GetMapping(value = "/calc/{fno}/{sno}")
    public String getAnswer(@PathVariable(name = "fno") int fno,
                            @PathVariable int sno){
        String text = "Answer is :" + (fno + sno);
        return text;
    }

    @PostMapping(value = "/setstudent")
    public String  setStudent(@RequestBody StudentDto studentDto){
        System.out.println(studentDto.getCode());
        System.out.println(studentDto.getFname());
        System.out.println(studentDto.getLname());
        return "Data Recived";
    }
}
