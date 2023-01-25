package com.example.Project.Controller;

import com.example.Project.Entity.Hospital;
import com.example.Project.Service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Controller.class)

class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HospitalService hospitalService;
    private Hospital hospital;

    @BeforeEach
    void setUp() {
         hospital = Hospital.builder()
                .StaffNumber(500)
                .Name("molo")
                .email("molo@gmail.com")
                .Id(3L)
                .build();

    }

    @Test
    @DisplayName("controller test")
    void addHospital() throws Exception {
        Hospital hospitalInput = Hospital.builder()
                .StaffNumber(500)
                .Name("molo")
                .email("molo@gmail.com")
                .Id(3L)
                .build();
        Mockito.when(hospitalService.addHospital(hospitalInput)).thenReturn(hospital);
        mockMvc.perform(post("/hospitals")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Name").value(hospital.getName()));
    }

    @Test
    @DisplayName("control test on fetch")
    void fetchHospitalById() throws Exception {
        Mockito.when(hospitalService.fetchHospitalById(3L)).thenReturn(hospital);
        mockMvc.perform(get("/hospitals/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
                                {
                                \t"name": "molo",
                                \t"email": "molo@gmail.com",
                                \t"id": 3,
                                \t"staffNumber": 500
                                }"""
                ))
                .andExpect(status().isOk());
    }
}