package model;
import java.io.Serializable;

public class User implements Serializable {
    protected String nick;
    protected String password;


    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick(){
        return this.nick;
    }

    public Boolean logIn(String password){
        return this.password.equals(password);
    }

    public Boolean changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) return false;
        this.password = newPassword;
        return true;
    }

    public Boolean isItAdmin() {
        return this instanceof Admin;
    }

    public Boolean isItStudent() {return this instanceof Student;}

    public Boolean isItTeacher() {return this instanceof Teacher;}

}
