package com.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.DTO.DemoDTO;
import com.CRUD.Service.DemoService;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/")
    public String show(){
        return"this is a demo project";
    }

    @PostMapping("add")
    public DemoDTO addDemoUser(@RequestBody DemoDTO demoDTO){
        return demoService.addDemoUser(demoDTO);
    }

    @GetMapping("all")
    public List<DemoDTO> getAllDemoUser(){
        return demoService.getAllDemoUsers();
    }
    
}
