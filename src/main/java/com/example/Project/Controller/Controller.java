package com.example.Project.Controller;


import com.example.Project.Entity.Hospital;
import com.example.Project.Service.HospitalService;
import com.example.Project.error.HospitalNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class Controller {
    @Autowired
    private HospitalService hospitalService;
//    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/hospitals")
    public Hospital addHospital(@Valid@RequestBody Hospital hospital){
//        logger.info("saving a hospital");
        return hospitalService.addHospital(hospital);
    }
    @GetMapping("/hospitals")
    public List<Hospital> getHospitals(){
        return hospitalService.getHospitals();
    }
    @GetMapping("/hospital/{name}")
    public Hospital getHospitalByName(@PathVariable("name") String name){
        return hospitalService.getHospitalByName(name);
    }
    @GetMapping("/hospitals/{id}")
    public Hospital fetchHospitalById(@PathVariable("id") Long id) throws HospitalNotFoundException {
        return hospitalService.fetchHospitalById(id);
    }
    @DeleteMapping("/delete/{Id}")
    public String deleteHospital(@PathVariable("Id")Long Id){
        hospitalService.deleteHospital(Id);
        return "Deleted successful";
    }
    @PutMapping("/update/{id}")
    public Hospital updateHospital( @PathVariable Long Id, @RequestBody Hospital hospital) throws HospitalNotFoundException {
        return hospitalService.updateHospital(Id,hospital);
    }

    }



