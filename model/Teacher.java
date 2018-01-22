package model;
import java.io.Serializable;

public class Teacher extends User {
        private String firstname;
        private String lastname;
        private String contact;

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

        public String getContact() {
            return this.contact;
        }

        public void setContact(String contact){
            this.contact=contact;
        }








}

