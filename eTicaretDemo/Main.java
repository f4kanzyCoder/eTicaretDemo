package eTicaretDemo;

import eTicaretDemo.business.abstracts.RegisterServices;
import eTicaretDemo.business.concrates.RegisterManager;
import eTicaretDemo.dataAccess.concrates.HibernateRegisterDao;
import eTicaretDemo.entities.concrates.Register;
import eTicaretDemo.google.GoogelMailManager;

public class Main {
    public static void main(String[] args) {
        Register uye = new Register(1, "Muhammed", "Sengul", "1234", "ms1907@gmail.com");
        Register uye2 = new Register(2, "E", "Demirog", "1234566", "engindemirog@gmail.com");
        Register uye3 = new Register(3, "Fatih", "Altin", "1234", "fatihaltingmail.com");
        Register uye4 = new Register(4, "Melis", "Aslan", "123452", "melisaslan@gmail.com");
        //google entegrasyonuna ve hibernate e erisim alani
        RegisterServices registerServices = new RegisterManager(new HibernateRegisterDao(), new GoogelMailManager());
        //Hibernate kontrol amacli olusturulmus uye
        registerServices.register(uye4.geteMail(), uye4.getFirstName(), uye4.getLastName(), uye4.getPassWord());
        System.out.println("-----------------------------------------");
        //Uye olma metoodu
        registerServices.register(uye.geteMail(), uye.getFirstName(), uye.getLastName(), uye.getPassWord());
//        System.out.println(
//                "First Name:"+uye.getFirstName()+""+"\nLast Name:"+uye.getLastName()+""+"\ne-Mail:"+uye.geteMail()
//        );
        System.out.println("-----------------------------------------");
        //Isim kontrolu eger 2 karekterden az sa hata veriyor
        registerServices.register(uye2.geteMail(), uye2.getFirstName(), uye2.getLastName(), uye.getPassWord());
        System.out.println("-----------------------------------------");
        //sifre kontrolu eger  6 karekterden az sa hata veriyor
        registerServices.register(uye3.geteMail(), uye3.getFirstName(), uye3.getLastName(), uye3.getPassWord());
        System.out.println("-----------------------------------------");
        //Dogrulama  e postasi gonderilen kisim (Mail gecerliyse)
        System.out.println(registerServices.verification(uye));
        System.out.println("-----------------------------------------");
        //eger gecersiz bir e posta girersek
        System.out.println(registerServices.verification(uye3));
        System.out.println("-----------------------------------------");
        //Maili e postadan onaylama simulasyonu
        registerServices.complateMembership(uye);
        //Sisteme giris metodu
        registerServices.sistemeGiris(uye);


    }
}
