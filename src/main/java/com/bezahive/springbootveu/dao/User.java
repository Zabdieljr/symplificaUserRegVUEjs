package com.bezahive.springbootveu.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table (name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column (name="firstName")
    private String firstName;
    @Column (name="lastName")
    private String lastName;
    @Column (name="userName", unique =true , nullable = false)
    private String userName;

    @Column (name="password", nullable = false)
    private String password;
    @Column (name="create_date", nullable = false)
    private LocalDateTime createDate;
    @Enumerated(EnumType.STRING)
    @Column (name="role", nullable = false)
    private Role role;

}
