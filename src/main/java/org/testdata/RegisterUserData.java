package org.testdata;

import org.commonmethods.CommonFunctions;

public class RegisterUserData {
    public static String firstName(){
        return "FirstName" + CommonFunctions.generateRandomString(3);
    }
    public static String lastName(){
        return "LastName" + CommonFunctions.generateRandomString(3);
    }
    public static String address(){
        return "Address "+CommonFunctions.generateRandomString(4);
    }
    public static String password(){
        return CommonFunctions.generateRandomString(10);
    }
    public static String country="Australia";
    public static String state="Western";
    public static String city="Sydney";
    public  static String zipCode="1000";
    public static String mobile="000000";
}
