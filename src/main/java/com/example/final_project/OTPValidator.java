package com.example.final_project;

class OTPMismatchException extends Exception {
    public OTPMismatchException(String message) {
        super(message);
    }
}

class OTPValidator {

    public static boolean checkOTP(String inputOTP, String storedOTP) throws OTPMismatchException {
        if (!storedOTP.equals(inputOTP)) {
            throw new OTPMismatchException("OTP mismatch: The entered OTP does not match the stored OTP.");
        } else {
            System.out.println("OTP is correct!");
            return true;
        }
    }
}

//// Example usage
//public class Main {
//    public static void main(String[] args) {
//        // Assume the stored OTP is "123456"
//        OTPValidator otpValidator = new OTPValidator("123456");
//
//        try {
//            // Try to check an OTP
//            otpValidator.checkOTP("654321");
//        } catch (OTPMismatchException e) {
//            // Handle the custom exception
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//}
