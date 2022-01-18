package com.example.userapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     @Column(name="user_Name")
     private String userName;

     @Column(name="first_Name")
     private String firstName;

     @Column(name="last_Name")
     private String lastName;

     @Column(name="mobile_Number")
     private String mobileNumber;

     @Column(name="email_Id")
     private String emailId;

     @Column(name="address_1")
     private String address1;

     @Column(name="adress_2")
     private String address2;
}
