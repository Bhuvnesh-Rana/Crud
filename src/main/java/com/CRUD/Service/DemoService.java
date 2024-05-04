package com.CRUD.Service;

import java.util.List;

import com.CRUD.DTO.DemoDTO;

public interface DemoService {
    
    DemoDTO addDemoUser(DemoDTO demoDTO);
    List<DemoDTO> getAllDemoUsers();
}
