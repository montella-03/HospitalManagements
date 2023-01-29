package com.example.Project.Repository;

import com.example.Project.Entity.Hospital;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest

class HospitalRepositoryTest {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Hospital hospital = Hospital.builder()
                .Id(2L)
                .email("nakuru@gmail.com")
                .Name("mombasa")
                .StaffNumber(900)
                .build();
        entityManager.persist(hospital);
    }

    @Test
    @DisplayName("Get by name")
  public   void findById() {
        Hospital hospital = hospitalRepository.findById(2L).get();
        assertEquals(hospital.getStaffNumber(),900);
    }
}