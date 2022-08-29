package eTicaretDemo.business.concrates;


import eTicaretDemo.business.abstracts.RegisterServices;
import eTicaretDemo.dataAccess.abstracts.RegisterDao;
import eTicaretDemo.entities.concrates.Register;
import eTicaretDemo.google.GoogelMailManager;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterManager implements RegisterServices {
    private RegisterDao registerDao;
    private GoogelMailManager googelMailManager;

    public RegisterManager() {
    }

    public RegisterManager(RegisterDao registerDao, GoogelMailManager googelMailManager) {
        this.registerDao = registerDao;
        this.googelMailManager = googelMailManager;
    }

    @Override
    public void register(String eMail, String firstName, String lastName, String passWord) {
        if (nameControl(firstName) == true || lastNameControl(lastName) == true) {
            System.out.println("Bilgileriniz kontrol ediniz !" + "\nAd veya Soyad hatali !");
            return;
        }
        if (passControl(passWord) == true) {
            System.out.println("Sifre 6 haneden fazla olmali !");
            return;
        } else System.out.println("Uyelik basarili:" + validateEmail(eMail));
        this.registerDao.register(eMail, firstName, lastName, passWord);
        this.googelMailManager.registerToSystem("");

    }

    @Override
    public boolean passControl(String passWord) {
        if (6 > passWord.length()) {

            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean nameControl(String firstName) {
        if (2 > firstName.length()) {

            return true;
        } else {

            return false;
        }

    }

    @Override
    public boolean lastNameControl(String lastName) {
        if (2 > lastName.length()) {
            return true;
        }
        return false;
    }

    @Override
    public String validateEmail(String eMail) {
        if (eMail == null || eMail.isEmpty()) {
            return "Invalid";
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(eMail).matches()) {
            return "Valid";

        } else {
            return "Invalid";
        }

    }

    @Override
    public String verification(Register register) {
        if (validateEmail(register.geteMail()).equals("Valid")) {

            return "Onaylama kodu mailinize gonderildi.";
        } else if (validateEmail(register.geteMail()).equals("Invalid")) {
            System.out.println("Gecerli bir mail adresi giriniz !");
        }
        return "";
    }

    @Override
    public void complateMembership(Register register) {
        System.out.println("Mail onaylandi.");

    }

    @Override
    public void sistemeGiris(Register register) {
        System.out.println("-------------------------------");
        System.out.println("Lutfen bilgilerinizi giriniz ");
        System.out.println("-------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("e Posta giriniz :");

        while (true) {
            String mail = scan.nextLine();
            System.out.println("Sifrenizi giriniz :");
            String pasw = scan.nextLine();
            if (mail.equals(register.geteMail()) && pasw.equals(register.getPassWord())) {
                System.out.println("Giris basarili.");
                break;
            } else System.out.println("Bilgiler yanlis kontorl ediniz.");
            break;
        }

    }
}
