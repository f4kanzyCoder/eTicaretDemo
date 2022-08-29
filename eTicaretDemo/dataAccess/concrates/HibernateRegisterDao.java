package eTicaretDemo.dataAccess.concrates;

import eTicaretDemo.dataAccess.abstracts.RegisterDao;
import eTicaretDemo.entities.concrates.Register;

public class HibernateRegisterDao implements RegisterDao {

    @Override
    public void register(String eMail, String firstName, String lastName, String passWord) {
        System.out.println("Hibarnete ile eklendi. ");
    }

    @Override
    public boolean passControl(String passWord) {
        return false;
    }

    @Override
    public boolean nameControl(String firstName) {
        return false;
    }

    @Override
    public boolean lastNameControl(String lastName) {
        return false;
    }

    @Override
    public String validateEmail(String eMail) {
        return null;
    }

    @Override
    public String verification(Register register) {
        return null;
    }

    @Override
    public void complateMembership(Register register) {

    }

    @Override
    public void sistemeGiris(Register register) {

    }
}
