package com.example.Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Hospital {
@jakarta.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
@NotBlank(message = "Hospital required")
    private String Name;
    private String email;
 private int StaffNumber;

}
