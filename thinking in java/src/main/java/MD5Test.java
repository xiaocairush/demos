import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by minjian.cai on 2014/10/10.
 */
public class MD5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String testString1 = "XXX75289753445jio";
        String str1 = encryptWithMD5(testString1);
        System.out.println(str1);
/*
        Thread thread = new Thread();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("出错了");
        }
        String testString2 = "XXX75289753445jio";
        String str2 = encryptWithMD5(testString2);

        System.out.println(str1.equals(str2));*/
    }

    private static String encryptWithMD5(String testString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String result = base64en.encode(md5.digest(testString.getBytes("utf-8")));
        return result;
    }
}
