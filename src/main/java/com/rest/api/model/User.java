package com.rest.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 2, message = "Name Should Have At Least 2 Characters")
    @Column(name = "name")
    private String name;

    @Past
    @Column(name = "birthdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date birthdate = new Date();

//    public User() {
//    }
//
//    public User(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//        this.birthdate =new Date();

//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Date getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(Date birthdate) {
//        this.birthdate = birthdate;
//    }
}
