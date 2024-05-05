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
        return modelMapper.map(demo, DemoDTO.class);
    }

    @Override
    public List<DemoDTO> getAllDemoUsers() {
        List<Demo> demo = demoRepo.findAll();
        List<DemoDTO> demoDTOs = demo.stream().map(a -> modelMapper.map(a, DemoDTO.class)).collect(Collectors.toList());
        return demoDTOs;
    }

    @Override
    public DemoDTO updateDemoUser(DemoDTO demoDTO, Integer id) {
        Demo demo = demoRepo.findById(id).get();
        demo.setName(demoDTO.getName());
        demo.setGender(demoDTO.getGender());
        demoRepo.save(demo);
        return modelMapper.map(demo, DemoDTO.class);
    }

    @Override
    public DemoDTO getDemoUserById(Integer id) {
        Demo demo = demoRepo.findById(id).get();
        return modelMapper.map(demo, DemoDTO.class);
    }

    @Override
    public String deleteDemoUser(Integer id) {
        Demo demo = demoRepo.findById(id).get();
        demoRepo.delete(demo);
        return "Demo user deleted wit id: "+demo.getId();
    }
    
}
