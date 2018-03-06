package model;
import java.io.Serializable;

public class Teacher extends User {
        private String firstname;
        private String lastname;

        public Teacher (String nick, String password, String firstname, String lastname) {
            super(nick, password);
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return this.firstname;
        }

        public String getLastname() {
            return this.lastname;
        }









}

