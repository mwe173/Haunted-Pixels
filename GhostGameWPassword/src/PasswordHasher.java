// Group 4 - Ashon, Caleb, Lauryn, Sydney, Betsy, Michelle
// CS265-01 Final Project

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;


public class PasswordHasher {

    // Helper method to convert byte[] to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(255 & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Method to hash a password and return the hex string representation
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashBytes);
    }
}
