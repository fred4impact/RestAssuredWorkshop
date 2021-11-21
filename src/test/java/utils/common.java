package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class common {

    public static String getValue() {
        String generateValue = RandomStringUtils.randomAlphabetic(1);
        return ("Bilarn"+generateValue);
    }

    public static String getUsername() {
        String generateValue = RandomStringUtils.randomAlphabetic(3);
        return("bill"+generateValue);
    }

    public static String getPassword() {
        String generateValue = RandomStringUtils.randomAlphabetic(3);
        return("passw"+generateValue);
    }

    public static String getEmail() {
        String generateValue = RandomStringUtils.randomAlphabetic(3);
        return(generateValue+"gmail.com");
    }
}
