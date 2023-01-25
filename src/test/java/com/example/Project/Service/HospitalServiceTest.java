package com.example.Project.Service;

import com.example.Project.Entity.Hospital;
import com.example.Project.Repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HospitalServiceTest {
    @Autowired
    private HospitalService hospitalService;
    @MockBean
    private HospitalRepository hospitalRepository;

    @BeforeEach
    void setUp() {
        Hospital hospital = Hospital.builder()
                        .Name("Nairobi")
                        .email("oigoc60@gmail.com")
                        .StaffNumber(30)
                        .Id(1L)
                        .build();
        Mockito.when(hospitalRepository.findByNameIgnoreCase("Nairobi")).thenReturn(hospital);
    }

    @Test
    void getHospitalByName() {
        String hospitalName="Nairobi";
        Hospital hospital= hospitalService.getHospitalByName(hospitalName);
        assertEquals(hospitalName,hospital.getName());
    }
}