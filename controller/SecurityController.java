package controller;

import exception.*;
import model.*;



import java.util.LinkedList;


public class SecurityController {
    private WD wd;
    private User user;


    public SecurityController(WD wd){
        this.wd=wd;

    }


    public Boolean registerAsStudent(String nick, String password, String firstname, String lastname, String studentID) {
        if (this.wd.isthisNickFree(nick)) {
            Student student = new Student(nick,password, firstname, lastname,studentID);
            this.user=student;
            return this.wd.addStudent(student);
        } else {
            return false;
        }
    }

    public Boolean registerTeacher(String nick, String password, String firstname, String lastname) {
        if (this.wd.isthisNickFree(nick)) {
            Teacher newTeacher = new Teacher(nick,password, firstname, lastname);
            return this.wd.addTeacher(newTeacher);
        } else {
            return false;
        }
    }


    public User logInAsStudent(String nick, String password) throws InvalidLoginOrPasswordException, InvalidDataExcepetion {
        Student student = this.wd.getStudentByNick(nick);
        if (student == null || !student.logIn(password)) throw new InvalidLoginOrPasswordException();
        else this.user= student;
        return this.user;
    }

    public User logInAsTeacher(String nick, String password) throws InvalidLoginOrPasswordException, InvalidDataExcepetion {
        Teacher teacher = this.wd.getTeacherByNick(nick);
        if (teacher == null || !teacher.logIn(password)) throw new InvalidLoginOrPasswordException();
        else this.user = teacher;
        return this.user;
    }

    public User logInAsAdmin(String nick, String password) throws InvalidLoginOrPasswordException, InvalidDataExcepetion {
        Admin admin = this.wd.getAdmin(nick);
        if (admin == null || !admin.logIn(password)) throw new InvalidLoginOrPasswordException();
        else this.user = admin;
        return this.user;
    }

    public User getUser(){
        return this.user;
    }




}
