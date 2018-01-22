package model;
import java.io.Serializable;

public class Mark implements Serializable{

    private float value;
    private String date;
    private String description;

    private Student student;
    private Subject subject;


    public Mark(float value, Student student, Subject subject, String date, String description) {
        if (value > 5.0 || value <2.0 || value%0.5!=0.0){
            System.out.println("Ocena musi byc z przedialu 2.0-5.0 oraz byc wielokrotnoscia 0.5");
        }
        else {
            this.value=value;
        }
        this.student = student;
        this.subject = subject;
        this.date = date;
        this.description = description;
    }
    public void setValue(float value) {
        if (value > 5.0 || value <2.0 || value%0.5!=0.0){
            System.out.println("Ocena musi byc z przedialu 2.0-5.0 oraz byc wielokrotnoscia 0.5");
        }
        else this.value=value;

    }

    public Subject getSubject(){
        return this.subject;
    }


    public String toString() {
        return this.value+" - "+this.description+", "+this.date;
    }
}
