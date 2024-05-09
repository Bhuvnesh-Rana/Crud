package com.CRUD.ServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

import com.CRUD.DTO.DemoDTO;
import com.CRUD.Entity.Demo;
import com.CRUD.Repository.DemoRepo;
import com.CRUD.Service.DemoService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DemoServiceImplTest {

    @Mock
    private DemoRepo demoRepo;
    private DemoService demoService;
    AutoCloseable autoCloseable;
    Demo demo;
    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        demoService = new DemoServiceImpl(demoRepo);
        demo = new Demo(1, "Random", "M");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testAddDemoUser() {
        mock(Demo.class);
        mock(DemoRepo.class);

        when(demoRepo.save(demo)).thenReturn(demo);
        DemoDTO d = modelMapper.map(demo, DemoDTO.class);
        assertThat(demoService.addDemoUser(d)).isEqualTo("Demo user "+demo.getName()+" added.");
        
    }

    @Test
    void testDeleteDemoUser() {

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

    }
}
