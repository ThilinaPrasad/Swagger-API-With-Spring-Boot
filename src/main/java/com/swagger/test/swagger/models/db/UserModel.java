package com.swagger.test.swagger.models.db;

import javax.persistence.*;

@Entity(name = "user")
public class UserModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id = null;

    @Column(name= "firstName")
    private String firstName = null;

    @Column( name = "lastName")
    private String lastName = null;

    @Column(name = "email")
    private String email = null;

    @Column(name = "password")
    private String password = null;

    @Column(name = "phone")
    private String phone = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
