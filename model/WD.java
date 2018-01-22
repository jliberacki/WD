package model;

import exception.*;

import java.util.LinkedList;
import java.io.Serializable;

public class WD implements Serializable{
    private LinkedList<Student> students;
    private LinkedList<Subject> subjects;
    private LinkedList<Teacher> teachers;

    private Admin admin;

    public WD() {
        students = new LinkedList<>();
        subjects = new LinkedList<>();
        teachers = new LinkedList<>();
        this.admin = new Admin("admin","admin");

    }

    public Boolean isthisNickFree(String nick) {
        for (Teacher teacher : teachers) {
            if (teacher.getNick().equals(nick)) return false;
        }
        for (Student student : students) {
            if (student.getNick().equals(nick)) return false;
        }
        return true;

    }


    public void printall(){
        for(Subject subject : subjects){
            System.out.println(subject.getName());
        }
        for (Student student : students) {
            System.out.println(student.getNick());
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getNick());
        }
    }



    public Boolean addTeacher(Teacher newTeacher) {
        return this.teachers.add(newTeacher);
    }

    public Boolean addStudent(Student newStudent) {
        return this.students.add(newStudent);
    }

    public Boolean addSubject(Subject newSubject) {
        for(Subject subject : subjects){
            if(subject.getName().equals(newSubject.getName()))return false;
        }
        return this.subjects.add(newSubject);
    }

    public Student getStudentByNick(String nick) throws InvalidDataExcepetion{
        for (Student student : students) {
            if (student.getNick().equals(nick)) return student;
        }
        throw new InvalidDataExcepetion();
    }

    public Admin getAdmin(String nick) throws InvalidDataExcepetion{
        if(nick.equals("admin")) return this.admin;
        throw new InvalidDataExcepetion();

    }


    public Teacher getTeacherByNick(String nick) throws InvalidDataExcepetion{
        for (Teacher teacher : teachers) {
            if (teacher.getNick().equals(nick)) return teacher;
        }
        throw new InvalidDataExcepetion();
    }

    public Teacher getTeacherByFirstAndLastName(String firstname, String lastname)throws InvalidDataExcepetion{
        for (Teacher teacher : teachers) {
            if (teacher.getFirstname().equals(firstname) && teacher.getLastname().equals(lastname)) return teacher;
        }
        throw new InvalidDataExcepetion();
    }

    public Student getStudentByID(String id) throws InvalidDataExcepetion{
        for (Student student : students) {
            if (student.getID().equals(id)) return student;
        }
        throw new InvalidDataExcepetion();
    }


    public Subject getSubjectByName(String subjectName) throws InvalidDataExcepetion{
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) return subject;
        }
        throw new InvalidDataExcepetion();
    }

    public Boolean deleteSubject(int number) throws IndexOutOfBoundsException{
        this.subjects.remove(number);
        return true;
    }

    public LinkedList<Subject> getSubjects() {
        return this.subjects;
    }

    public boolean printMarks(Student student, Subject subject){
        boolean hasMarks=false;
        LinkedList<Mark> marks;
        marks = student.getMarksList();
        for(Mark mark : marks){
            if(mark.getSubject().equals(subject)){
                hasMarks=true;
                System.out.println(mark);
            }
        }
        return hasMarks;
    }



}
