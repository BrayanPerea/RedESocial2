package com.example.Hackaton.DTO.UserDTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    private int dni;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String country;

    @Column
    private String region;

    @Column
    private int age;

}
