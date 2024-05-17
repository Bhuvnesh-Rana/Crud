package com.CRUD.ServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.CRUD.DTO.DemoDTO;
import com.CRUD.Entity.Demo;
import com.CRUD.Repository.DemoRepo;
import com.CRUD.Service.DemoService;




public class DemoServiceImplTest {

    @Mock
    private DemoRepo demoRepo;
    private DemoService demoService;
    AutoCloseable autoCloseable;
    Demo demo;
    // @Autowired
    // ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
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

        when(demoRepo.save(demo)).thenReturn(demo);
        // DemoDTO d = modelMapper.map(demo, DemoDTO.class);
        DemoDTO d = demoToDemoDTO(demo);
        assertThat(demoService.addDemoUser(d)).isEqualTo("Demo user "+demo.getName()+" added.");
        
    }
    private DemoDTO demoToDemoDTO(Demo demo) {
		DemoDTO demoDto = new DemoDTO();
		demoDto.setId(demo.getId());
		demoDto.setName(demo.getName());
		demoDto.setGender(demo.getGender());
		
		return demoDto;
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
