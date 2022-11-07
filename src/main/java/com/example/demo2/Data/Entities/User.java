package com.example.demo2.Data.Entities;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Optional;

@Entity
@Table(name = "\"user\"")
public class User extends BaseEntity{

        //private static final long serialVersionUID = -2323571384056059081L;

        @Column(name = "username")
        @NotNull
        protected String username;

        @Column(name = "password")
        @NotNull
        protected String password;

        @Column(name = "firstName")
        @NotNull
        protected String firstName;

        @Column(name = "lastName")
        @NotNull
        protected String lastName;

        @Column(name = "emailAddress")
        @NotNull
        protected String emailAddress;

        public User(String username, String password, String firstName, String lastName, String emailAddress) {
        }

        public User(String username, String password, String firstName, String lastName, String emailAddress,
                    String address) {
            this.username = username;
            this.password = new BCryptPasswordEncoder().encode(password);
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;

        }


    public User() {

    }
    public String getFirstName() {
        return firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
