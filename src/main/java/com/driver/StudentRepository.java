package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {
    private List<Student> studentList =new ArrayList<>();
   private   List<Teacher> teacherList =new ArrayList<>();

   private HashMap<String,List<String>> teacherWithStudentMap=new HashMap<>();
    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        List<String> studentsWithOneTeacher;
        if(teacherWithStudentMap.containsKey(teacher)){
            studentsWithOneTeacher = teacherWithStudentMap.get(teacher);
        }else{
            studentsWithOneTeacher = new ArrayList<>();
        }
        studentsWithOneTeacher.add(student);
        teacherWithStudentMap.put(teacher,studentsWithOneTeacher);
    }

    public Student getStudentByName(String name) {
        for(Student student:studentList){
            if(student.getName().equals(name))return student;
        }
        return null;
    }

    public Teacher getTeacherByName(String name) {
        for (Teacher teacher:teacherList){
            if(teacher.getName().equals(name))return teacher;
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return teacherWithStudentMap.get(teacher);
    }

    public List<String> getAllStudents() {
       List<String> allStudent=new ArrayList<>();
       for (Student student:studentList){
           allStudent.add(student.getName());
       }
       return allStudent;
    }

    public void deleteTeacherByName(String teacher) {
//        List<String> deleteStudents=teacherWithStudentMap.get(teacher);
//        for(String name:deleteStudents){
//            studentList.remove(name);
//        }
        teacherWithStudentMap.remove(teacher);
        teacherList.remove(teacher);
    }

    public void deleteAllTeachers() {
        studentList.clear();
        teacherList.clear();
        teacherWithStudentMap.clear();
    }
}
