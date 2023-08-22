package com.example.users.entities;


import javax.persistence.*;

@Entity
@Table(name= " users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "passwrod")
    private String password;
    @Column(name = "profile")
    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
}
