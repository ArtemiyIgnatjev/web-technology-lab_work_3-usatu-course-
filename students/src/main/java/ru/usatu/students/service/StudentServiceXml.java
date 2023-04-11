package ru.usatu.students.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import ru.usatu.students.model.Student;
import ru.usatu.students.model.StudentList;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceXml implements StudentService {

    private static final String FILE_PATH = "C:\\Users\\1\\Desktop\\students\\src\\main\\resources\\students.xml";

    @Override
    public List<Student> getStudents() throws Exception {
        return getStudentList().getStudents();
    }

    @Override
    public Student getStudent(int id) throws Exception {
        return getStudents().stream().filter(student -> student.getId() == id).findFirst().orElse(new Student());
    }

    @Override
    public Student addStudent(Student student) throws Exception {
        StudentList studentList = getStudentList();
        studentList.getStudents().add(student);
        save(studentList);
        return student;
    }

    @Override
    public Student editStudent(int id, String name) throws Exception {
        StudentList studentList = getStudentList();
        Student findStudent = studentList.getStudents().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
        if (findStudent == null) {
            return new Student();
        }
        findStudent.setName(name);
        save(studentList);
        return findStudent;
    }

    @Override
    public void deleteStudent(int id) throws Exception{
        StudentList studentList = getStudentList();
        Student findStudent = studentList.getStudents().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
        if (findStudent != null){
            studentList.getStudents().remove(findStudent);
            save(studentList);
        }
    }



    private StudentList getStudentList() throws Exception{
        File file = new File(FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Unmarshaller unMarshaller = context.createUnmarshaller();
        return (StudentList) unMarshaller.unmarshal(file);
    }

    private void save(StudentList studentList) throws Exception{
        File file = new File(FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(studentList, file);
    }


}

