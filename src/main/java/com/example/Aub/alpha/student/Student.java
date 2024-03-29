package com.example.Aub.alpha.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
@Id
@SequenceGenerator(
        name="student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
)
@GeneratedValue(strategy = GenerationType.SEQUENCE,
generator = "student_sequence")

        private Long id;
        private String name;
        private Integer grade;
        private	String email;
        private LocalDate dob;
        private String street;
        private String city;
        private String state;
        private Integer zipcode;
        @Transient
        private Integer age;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Student(Integer grade){
        this.grade = grade;
    }
    public Student(Long id, String name, String email, LocalDate dob, Integer grade, String street, String city, String state, Integer zipcode){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.grade = grade;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Student(String name, String email, LocalDate dob, Integer grade, String street, String city, String state, Integer zipcode){
        this.name=name;
        this.email=email;
        this.dob=dob;
        this.grade = grade;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;

    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public LocalDate getDob(){
        return dob;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public Integer getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public  String toString(){
        return "Student{" +
                "id=" + id+
                ", name='" +name +'\''+
                ", email='" +email +'\''+
                ", grade='" +grade +'\''+
                ", dob=" + dob +
                ", age=" +age +
                ", address='"+street + '\''+city +'\''+state + '\''+zipcode+
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }
}
