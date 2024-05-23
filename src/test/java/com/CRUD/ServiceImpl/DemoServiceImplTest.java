package com.CRUD.ServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
// import org.modelmapper.convention.NameTokenizers;
import org.springframework.beans.factory.annotation.Autowired;

import com.CRUD.DTO.DemoDTO;
import com.CRUD.Entity.Demo;
import com.CRUD.Repository.DemoRepo;
import com.CRUD.Service.DemoService;




public class DemoServiceImplTest {

    @Mock
    private DemoRepo demoRepo;
    private DemoService demoService;
    AutoCloseable autoCloseable;        //to close all the unwanted resources, when test execution is finished.
    Demo demo;
    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
        // this.modelMapper = new ModelMapper();
        // modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
        autoCloseable = MockitoAnnotations.openMocks(this);
        demoService = new DemoServiceImpl(demoRepo);
        demo = new Demo(1,"Random",'M');
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testAddDemoUser() {
        mock(DemoDTO.class);
        mock(DemoRepo.class);
        modelMapper = mock(ModelMapper.class);

        when(demoRepo.save(demo)).thenReturn(demo);
        // DemoDTO d = this.modelMapper.map(demo, DemoDTO.class);
        DemoDTO d = demoToDemoDTO(demo);
        assertThat(demoService.addDemoUser(d)).isEqualTo("Demo user "+demo.getName()+" added.");
        
    }
   
    @Test
    void testDeleteDemoUser() {     //does not have a return type -- void mthd.
    mock(DemoDTO.class);
    mock(DemoRepo.class,Mockito.CALLS_REAL_METHODS);

    //     Demo abc = demoRepo.findById(demo.getId());      //WRONG use data created in test directly.
    // doAnswer(Answers.CALLS_REAL_METHODS).when(demoRepo.delete(abc));
    //     assertThat(demoService.deleteDemoUser(1)).isEqualTo("Demo user deleted with id: ");

    doAnswer(Answers.CALLS_REAL_METHODS).when(demoRepo).deleteById(1); //can also write any() as id.
        assertThat(demoService.deleteDemoUser(1)).isEqualTo("Demo user deleted with id: "+demo.getId());
    }

    @Test
    void testGetAllDemoUsers() {

    }

    @Test
    void testGetDemoUserById() {

    }

    @Test
    void testServiceFindById() {

    }

    @Test
    void testUpdateDemoUser() {
        mock(DemoDTO.class);
        mock(DemoRepo.class);

        when(demoRepo.findById(1)).thenReturn(Optional.ofNullable(demo));
        when(demoRepo.save(demo)).thenReturn(demo);
        // DemoDTO d = modelMapper.map(demo, DemoDTO.class);
        DemoDTO d = demoToDemoDTO(demo);
        assertThat(demoService.updateDemoUser(d, 1)).isEqualTo("Demo user details updated.");
    }

    private DemoDTO demoToDemoDTO(Demo demo) {
		DemoDTO demoDto = new DemoDTO();
		demoDto.setId(demo.getId());
		demoDto.setName(demo.getName());
		demoDto.setGender(demo.getGender());
		
		return demoDto;
    }

}
