package com.CRUD.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.CRUD.DTO.DemoDTO;
import com.CRUD.Service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebMvcTest
public class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DemoService demoService;
    DemoDTO demoDTO1;
    DemoDTO demoDTO2;
    List<DemoDTO> demoDTOs = new ArrayList<>();

    @BeforeEach
    void setUp(){
        demoDTO1 = new DemoDTO(1, "Random", 'M');
        demoDTO2 = new DemoDTO(2,"Abcd",'F');
        demoDTOs.add(demoDTO1);
        demoDTOs.add(demoDTO2);
    }

    @AfterEach
    void tearDown(){

    }


    @Test
    void testAddDemoUser() throws Exception {
        // Converting demoDTO1 to json format, @RequestBody requires json input in controller.
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(demoDTO1);

        when(demoService.addDemoUser(demoDTO1)).thenReturn("Demo user "+demoDTO1.getName()+" added.");
        this.mockMvc.perform(post("/demo").contentType(MediaType.APPLICATION_JSON)
                                                      .content(requestJson))    //accepting JSON.
                                                      .andDo(print())
                                                      .andExpect(status().isCreated());

    }

    @Test
    void testDeleteDemoUser() throws Exception {
        if (when(demoService.serviceFindById(1)).thenReturn(true) != null) {
            when(demoService.deleteDemoUser(1)).thenReturn("Demo user deleted with id: "+demoDTO1.getId());
            this.mockMvc.perform(delete("/demo/1")).andDo(print()).andExpect(status().isOk());
        }
    }

    @Test
    void testGetAllDemoUser() throws Exception {
        // DemoDTO d = demoToDemoDTO(demo1);        //no need, using DTO Constructor.
        when(demoService.getAllDemoUsers()).thenReturn(demoDTOs);
        this.mockMvc.perform(get("/demo")).andDo(print()).andExpect(status().isOk());     //import get etc manually
        }
    

    @Test
    void testGetDemoUserById() throws Exception {
        if (when(demoService.serviceFindById(1)).thenReturn(true) != null) {
        when(demoService.getDemoUserById(1)).thenReturn(demoDTO1);
        this.mockMvc.perform(get("/demo/1")).andDo(print()).andExpect(status().isOk());     //import get etc manually
        }
    }

    @Test
    void testShow() {

    }

    @Test
    void testUpdateDemoUser() {

    }

    // NO NEED USING DTO CONSTRUCTOR INSTEAD, USED ENTITY CONSTR IN SERVICE LAYER TESTING.
    // private DemoDTO demoToDemoDTO(Demo demo) {
	// 	DemoDTO demoDto = new DemoDTO();
	// 	demoDto.setId(demo.getId());
	// 	demoDto.setName(demo.getName());
	// 	demoDto.setGender(demo.getGender());
		
	// 	return demoDto;
    // }


}
