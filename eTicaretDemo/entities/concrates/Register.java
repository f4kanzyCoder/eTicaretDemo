package eTicaretDemo.entities.concrates;

import eTicaretDemo.entities.abstracts.Entity;

public class Register implements Entity {
    private int id;
    private String firstName;
    private String lastName;
    private String passWord;
    private String eMail;
    public Register(){}
    public Register(int id, String firstName, String lastName, String passWord, String eMail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
