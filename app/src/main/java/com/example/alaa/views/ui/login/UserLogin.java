package com.example.alaa.views.ui.login;

public class UserLogin {

    // Login
    private String phoneNumber;
    private String personalNumber;

    //SignUp
    private String name;
    private String lastName;
    private String gender;
    private String address;
    private String email;
    private String major;

    public UserLogin(String phoneNumber, String personalNumber, String name, String lastName, String gender, String address, String email, String major) {
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.major = major;
    }

    public UserLogin(String phoneNumber, String personalNumber) {
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }



}
