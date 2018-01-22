package model;

import java.util.LinkedList;

public class Student extends User {
    private String firstname;
    private String lastname;
    private String studentID;
    private String contact;

    private LinkedList<Mark> marks;

    public Student(String nick, String password, String firstname, String lastname, String studentID) {
        super(nick, password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
        marks = new LinkedList<>();
    }


    public String getID() {
        return this.studentID;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean getMark(Mark mark){
        return this.marks.add(mark);
    }

    public LinkedList<Mark> getMarksList() {
        return this.marks;
    }

}
