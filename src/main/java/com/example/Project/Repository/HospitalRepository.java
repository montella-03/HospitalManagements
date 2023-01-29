package com.example.Project.Repository;

import com.example.Project.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository


public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    @Query(
            value = "SELECT * FROM hospital s where s.name=?1",
            nativeQuery = true
    )
    Hospital findByNameIgnoreCase(String name);
}
