package com.example.Project.Service;

import com.example.Project.Entity.Hospital;
import com.example.Project.error.HospitalNotFoundException;

import java.util.List;

public interface HospitalService {
    Hospital addHospital(Hospital hospital);

  List<Hospital> getHospitals();

    Hospital getHospitalByName(String name);

     void deleteHospital(Long Id);

     Hospital fetchHospitalById(Long id) throws HospitalNotFoundException;

      Hospital updateHospital(Long id, Hospital hospital) throws HospitalNotFoundException;
}
