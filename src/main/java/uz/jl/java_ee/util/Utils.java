package uz.jl.java_ee.util;

import lombok.NonNull;

import javax.servlet.http.Part;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/14:10 (Tuesday)
 * java-ee/IntelliJ IDEA
 */
public class Utils {
    public static boolean isDigit(@NonNull String character) {
        if (character.isBlank())
            return false;
        for (char ch : character.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static String generateUniqueFileName() {
        return System.currentTimeMillis() + ".pdf";
    }
}
