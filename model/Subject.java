package model;

import java.io.Serializable;

public class Subject implements Serializable{
    private String name;

    private Teacher teacher;

    public Subject(String name, Teacher teacher){
        this.name=name;
        this.teacher=teacher;
    }

    public String getName() {
        return name;
    }
}
