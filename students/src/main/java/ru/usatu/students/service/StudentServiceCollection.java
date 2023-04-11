package ru.usatu.students.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Primary
@Service
public class StudentServiceCollection implements StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentServiceCollection() {
        students.add(new Student(1,"Ivan"));
        students.add(new Student(2,"Ivan2"));
        students.add(new Student(3,"Ivan3"));
    }
    public List<Student> getStudents() { return students; }

    public Student getStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .orElse(new Student());
    }

    public Student addStudent(Student student){
        students.add(student);
        return student;
    }

    public Student editStudent(int id, String name) {
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .map(student -> {
                    student.setName(name);
                    return student;
                }).orElse(new Student());
    }

    public void deleteStudent(int id) {
        students = students.stream().filter(student -> student.getId() != id)
                .collect(Collectors.toList());
    }
}
