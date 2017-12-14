package com.example.edeleon8425.popfizzle;

public class User {

    //variables
    int id;
    String uname;
    String password;
    String firstname;
    String lastname;
    String email;

    // Constructor with two parameters name and password
    public User(String uname,String password)
    {
        this.uname=uname;
        this.password=password;
    }

    // Constructor with all parameters
    public User(String uname,String password, String firstname, String lastname, String email)
    {
        this.uname=uname;
        this.password=password;
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
    }

    //getting id
    public int getId() {
        return id;
    }
    //setting id
    public void setId(int id) {
        this.id = id;
    }

    //getting name
    public String getName() {
        return uname;
    }
    //setting name
    public void setName(String uname) {
        this.uname = uname;
    }

    //getting password
    public String getPassword() {
        return password;
    }
    //setting password
    public void setPassword(String password) {
        this.password = password;
    }

    //getting firstname
    public String getFirstname() {
        return firstname;
    }
    //setting firstname
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    //getting lastname
    public String getLastname() {
        return firstname;
    }
    //setting lastname
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //getting email
    public String getEmail() {
        return firstname;
    }
    //setting email
    public void setEmail(String email) {
        this.email = email;
    }
}