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

import com.CRUD.ApiResponse.ApiResponse;
import com.CRUD.ApiResponse.ApiResponseMessage;
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
    public ResponseEntity<ApiResponseMessage> addDemoUser(@RequestBody DemoDTO demoDTO){
        return new ResponseEntity<>(new ApiResponseMessage(true, demoService.addDemoUser(demoDTO)), HttpStatus.CREATED);
    }

    @GetMapping("demo")
    public ResponseEntity<List<DemoDTO>> getAllDemoUser(){
        return new ResponseEntity<List<DemoDTO>>(demoService.getAllDemoUsers(),HttpStatus.OK);
    }

    @PutMapping("demo/{id}")
    public ResponseEntity<ApiResponseMessage> updateDemoUser(@RequestBody DemoDTO demoDTO, @PathVariable Integer id){
        if (demoService.serviceFindById(id)) 
            return new ResponseEntity<>(new ApiResponseMessage(true, demoService.updateDemoUser(demoDTO, id)), HttpStatus.OK);
        else
            return new ResponseEntity<>(new ApiResponseMessage(false, "No demo user found with id "+id+" to update."), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/demo/{id}")
    public ResponseEntity<ApiResponse> getDemoUserById(@PathVariable Integer id){
        if (demoService.serviceFindById(id)) {
            return new ResponseEntity<>(new ApiResponse(true,"Demo user found",demoService.getDemoUserById(id)), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(new ApiResponse(false, "No demo user found with id "+id),HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("demo/{id}")
    public ResponseEntity<ApiResponseMessage> deleteDemoUser(@PathVariable Integer id){
        if (demoService.serviceFindById(id)) 
            return new ResponseEntity<>(new ApiResponseMessage(true, demoService.deleteDemoUser(id)), HttpStatus.OK);
        else
            return new ResponseEntity<>(new ApiResponseMessage(false, "No demo user found with id "+id+" to delete."), HttpStatus.NOT_FOUND);

        
    }
    
}
