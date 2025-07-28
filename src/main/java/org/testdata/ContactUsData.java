package org.testdata;

import org.commonmethods.CommonFunctions;

public class ContactUsData {
    public static String firstName() {
        return "FirstName" + CommonFunctions.generateRandomString(3);
    }

    public static String email() {
        return firstName() + "@gmail.com";
    }

    public static String inputFilePath() {
        String inputFilePath = "\\src\\main\\java\\org\\testdata\\ContactUsInputFile.txt";
        return System.getProperty("user.dir") + inputFilePath;
    }
}
