package com.CRUD.Service;

import java.util.List;

import com.CRUD.DTO.DemoDTO;

public interface DemoService {
    
    DemoDTO addDemoUser(DemoDTO demoDTO);
    DemoDTO updateDemoUser(DemoDTO demoDTO, Integer id);
    List<DemoDTO> getAllDemoUsers();
    DemoDTO getDemoUserById(Integer id);
    String deleteDemoUser(Integer id);
}
