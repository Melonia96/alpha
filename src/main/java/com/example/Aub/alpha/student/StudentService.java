package com.example.Aub.alpha.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student with Id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String street, String city, String state, Integer zipcode,String email, Integer grade){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with Id" + studentId + " does not exist"));
        if (name != null &&
        name.length() > 0 &&
        !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (street != null &&
                street.length() > 0 &&
                !Objects.equals(student.getStreet(), street)) {
            student.setStreet(street);
        }
        if (city != null &&
                city.length() > 0 &&
                !Objects.equals(student.getCity(), city)) {
            student.setCity(city);
        }
        if (state != null &&
                state.length() > 0 &&
                !Objects.equals(student.getState(), state)) {
            student.setState(state);
        }
        if (zipcode != null &&
                !Objects.equals(student.getZipcode(), zipcode)) {
            student.setZipcode(zipcode);
        }
        if (email != null &&
                email.length()> 0 &&
                !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
        if (grade != null &&
                !Objects.equals(student.getGrade(), grade)) {
            student.setGrade(grade);
        }

    }

}