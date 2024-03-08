package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class MyEntity {
    private int id;
    private String first_name;
//    private String last_name;
//    private String email;
//    private String gender;
//    private Date date_of_birth;
//    private String country;
}
