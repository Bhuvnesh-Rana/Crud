package com.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("demo")
    public ResponseEntity<DemoDTO> addDemoUser(@RequestBody DemoDTO demoDTO){
        return new ResponseEntity<DemoDTO>(demoService.addDemoUser(demoDTO), HttpStatus.CREATED);
    }

    @GetMapping("demo")
    public ResponseEntity<List<DemoDTO>> getAllDemoUser(){
        return new ResponseEntity<List<DemoDTO>>(demoService.getAllDemoUsers(),HttpStatus.OK);
    }

    @PutMapping("demo/{id}")
    public ResponseEntity<DemoDTO> updateDemoUser(@RequestBody DemoDTO demoDTO, @PathVariable Integer id){
        return new ResponseEntity<>(demoService.updateDemoUser(demoDTO, id), HttpStatus.OK);
    }

    @GetMapping("demo/{id}")
    public ResponseEntity<DemoDTO> getDemoUserById(@PathVariable Integer id){
        return new ResponseEntity<>(demoService.getDemoUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("demo/{id}")
    public String deleteDemoUser(@PathVariable Integer id){
        return demoService.deleteDemoUser(id);
    }
    
}
