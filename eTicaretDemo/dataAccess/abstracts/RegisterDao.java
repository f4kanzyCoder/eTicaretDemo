package eTicaretDemo.dataAccess.abstracts;

import eTicaretDemo.entities.concrates.Register;

public interface RegisterDao {

    void register(String eMail, String firstName, String lastName, String passWord);

    boolean passControl(String passWord);

    boolean nameControl(String firstName);

    boolean lastNameControl(String lastName);

    String validateEmail(String eMail);

    String verification(Register register);

    void complateMembership(Register register);

    void sistemeGiris(Register register);
}
