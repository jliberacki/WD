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

    public static Boolean isItAdmin(User user) {
        return user instanceof Admin;
    }

    public static Boolean isItStudent(User user) {
        return user instanceof Student;
    }

    public static Boolean isItTeacher(User user) {
        return user instanceof Teacher;
    }

    public enum UserTypes {
        ADMIN, STUDENT, TEACHER
    }

    public static UserTypes UserType(User user){
        if(isItAdmin(user)){
            return UserTypes.ADMIN;
        }
        else if (isItStudent(user)){
            return UserTypes.STUDENT;
        }
        else if(isItTeacher(user)){
            return UserTypes.TEACHER;
        }
        else return null;
    }




}
