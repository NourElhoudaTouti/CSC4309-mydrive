package com.example.demo2.Data.dtos;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable{

        private Long id;
        private String username;
        private String password;
        private String newPassword;
        private String firstName;
        private String lastName;
        private String emailAddress;

    public User(String username, Object o, String firstName, String lastName, String emailAddress) {
    }

    public void user() {
        }

        public Long getId() {
            return id;
        }


        public void setId(Long id) {
            this.id = id;
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

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }

        public String getFirstName() {
            return firstName;
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

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

    public Arrays getAuthorities() {
        return null;
    }
}

