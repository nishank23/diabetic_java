package com.example.diabetic.Utils;

import java.util.Random;

public class Utils {
    public static String generateOtp(){
        int otp = 100000 + new Random().nextInt(900000);
        return String.valueOf(otp);
    }
}
