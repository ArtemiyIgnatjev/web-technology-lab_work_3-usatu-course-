package ru.usatu.students.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {

    @XmlElement(name = "student")
    private List<Student> students;

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

}
