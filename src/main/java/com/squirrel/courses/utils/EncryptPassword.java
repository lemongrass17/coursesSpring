package com.squirrel.courses.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Class for encrypting password
 *
 * @author  Bogdan Popovich
 */
public class EncryptPassword {

    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password1 = "Hahc";
        String password2 = "GaeR";
        String password3 = "pe9W";
        String password4 = "Xah2";
        String password5 = "Awoo";
        String password6 = "ou4a";
        String password7 = "Zie0";
        String password8 = "Anga";
        String password9 = "oes6";
        String password10 = "cuo3";
        String password11 = "Jee7";

        String encrytedPassword1 = encrytePassword(password1);
        String encrytedPassword2 = encrytePassword(password2);
        String encrytedPassword3 = encrytePassword(password3);
        String encrytedPassword4 = encrytePassword(password4);
        String encrytedPassword5 = encrytePassword(password5);
        String encrytedPassword6 = encrytePassword(password6);
        String encrytedPassword7 = encrytePassword(password7);
        String encrytedPassword8 = encrytePassword(password8);
        String encrytedPassword9 = encrytePassword(password9);
        String encrytedPassword10 = encrytePassword(password10);
        String encrytedPassword11 = encrytePassword(password11);

        System.out.println("Encryted Password 1: " + encrytedPassword1);
        System.out.println("Encryted Password 2: " + encrytedPassword2);
        System.out.println("Encryted Password 3: " + encrytedPassword3);
        System.out.println("Encryted Password 4: " + encrytedPassword4);
        System.out.println("Encryted Password 5: " + encrytedPassword5);
        System.out.println("Encryted Password 6: " + encrytedPassword6);
        System.out.println("Encryted Password 7: " + encrytedPassword7);
        System.out.println("Encryted Password 8: " + encrytedPassword8);
        System.out.println("Encryted Password 9: " + encrytedPassword9);
        System.out.println("Encryted Password 10: " + encrytedPassword10);
        System.out.println("Encryted Password 11: " + encrytedPassword11);
    }
}
