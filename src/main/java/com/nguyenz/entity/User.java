package com.nguyenz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    @Column(name= "phone_number")
    private String phoneNumber;
    @Column(name= "is_admin")
    private boolean isAdmin;
    @Column(name = "is_active")
    private boolean isActive;
}
