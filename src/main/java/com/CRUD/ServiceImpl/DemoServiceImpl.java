package com.CRUD.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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

    public DemoServiceImpl(DemoRepo demoRepo) {         //used in testing
        this.demoRepo=demoRepo;
    }

    @Override
    public String addDemoUser(DemoDTO demoDTO) {
        // Demo demo = modelMapper.map(demoDTO, Demo.class);        //model mapper not working fofr test.
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoDTO, demo);
        demoRepo.save(demo);
        // modelMapper.map(demo, DemoDTO.class);
        return "Demo user "+demo.getName()+" added.";
    }

    @Override
    public List<DemoDTO> getAllDemoUsers() {
        List<Demo> demo = demoRepo.findAll();
        // List<DemoDTO> demoDTOs = demo.stream().map(a -> modelMapper.map(a, DemoDTO.class)).collect(Collectors.toList());
        List<DemoDTO> demoDTOs = demo.stream().map(a -> demoToDemoDTO(a)).collect(Collectors.toList());
        return demoDTOs;
    }

    @Override
    public String updateDemoUser(DemoDTO demoDTO, Integer id) {
        Demo demo = demoRepo.findById(id).get();
        demo.setName(demoDTO.getName());
        demo.setGender(demoDTO.getGender());
        demoRepo.save(demo);
        // modelMapper.map(demo, DemoDTO.class);
        return "Demo user details updated.";
    }

    @Override
    public DemoDTO getDemoUserById(Integer id) {
        Demo demo = demoRepo.findById(id).get();
        // return modelMapper.map(demo, DemoDTO.class);
        return demoToDemoDTO(demo);
    }

    @Override
    public String deleteDemoUser(Integer id) {      //made changesss
        // Demo demo = demoRepo.findById(id).get();
        // demoRepo.delete(demo);
        demoRepo.deleteById(id);
        return "Demo user deleted with id: "+id; 
    }

    @Override
    public boolean serviceFindById(Integer id) {
        if (demoRepo.existsById(id)) 
            return true;
        else
            return false;
    }

    private DemoDTO demoToDemoDTO(Demo demo) {
		DemoDTO demoDto = new DemoDTO();
		demoDto.setId(demo.getId());
		demoDto.setName(demo.getName());
		demoDto.setGender(demo.getGender());
		
		return demoDto;
    }
    
}
