package com.example.Project.Service;

import com.example.Project.Entity.Hospital;
import com.example.Project.Repository.HospitalRepository;
import com.example.Project.error.HospitalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HospitalServiceImp implements HospitalService{
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalByName(String name) {
        return hospitalRepository.findByNameIgnoreCase(name);
    }

    @Override
    public void deleteHospital(Long Id) {
        hospitalRepository.deleteById(Id);
    }

    @Override
    public Hospital fetchHospitalById(Long id) throws HospitalNotFoundException {
        Optional<Hospital> hospital=hospitalRepository.findById(id);
        if(hospital.isEmpty())
            throw new HospitalNotFoundException("Hospital is not available");
        return hospital.get();
    }

    @Override
    public Hospital updateHospital(Long id, Hospital hospital) throws HospitalNotFoundException {
        Optional<Hospital> hospital1=hospitalRepository.findById(id);
        if(hospital1.isEmpty())
            throw new HospitalNotFoundException("Hospital is not available");
         Hospital hospital2 = hospital1.get();

        if (Objects.nonNull(hospital.getName()) &&
                !"".equals(hospital.getName())) {
            hospital2.setName(hospital.getName());
        }
        if (Objects.nonNull(hospital.getEmail()) &&
                !"".equals(hospital.getEmail())) {
            hospital2.setEmail(hospital.getEmail());
        }
        hospital2.setStaffNumber(hospital.getStaffNumber());
        return hospitalRepository.save(hospital2);
    }
}
