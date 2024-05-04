package com.CRUD.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.DTO.DemoDTO;
import com.CRUD.Entity.Demo;
import com.CRUD.Repository.DemoRepo;
import com.CRUD.Service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoRepo demoRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DemoDTO addDemoUser(DemoDTO demoDTO) {
        Demo demo = modelMapper.map(demoDTO, Demo.class);
        demoRepo.save(demo);
        return demoDTO;
    }

    @Override
    public List<DemoDTO> getAllDemoUsers() {
        List<Demo> demo = demoRepo.findAll();
        List<DemoDTO> demoDTOs = demo.stream().map(a -> modelMapper.map(demo, DemoDTO.class)).collect(Collectors.toList());
        return demoDTOs;
    }
    
}
