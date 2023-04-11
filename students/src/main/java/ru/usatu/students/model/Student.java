package ru.usatu.students.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@Entity
@Table(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @Id
    @XmlElement(name = "id")
    private int id;
    @Column
    @XmlElement(name = "name")
    private String name;

    public Student() {  }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }


}
