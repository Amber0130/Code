package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderutils {
    private static BCryptPasswordEncoder bCryptPasswordEncode = new BCryptPasswordEncoder();

    public String encodePassword(String password) {
        return bCryptPasswordEncode.encode(password);
    }

    public static void main(String[] args) {
        String password = "macbook";
        //$2a$10$Ujm2jCGmdhMKNdS9gqMoB.s4eKoQffmjy/hWnMDwOkfLrqeEm7To6
        //$2a$10$AMkwoirZXA5/MIgtp4fVROgo2861FeSDbWy4EZqwvkcAotno28OBu
        System.out.println(bCryptPasswordEncode.encode(password));
    }
}
