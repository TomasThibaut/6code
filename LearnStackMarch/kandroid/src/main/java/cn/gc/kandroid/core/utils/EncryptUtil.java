package cn.gc.kandroid.core.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 宫成 on 16/3/31 下午4:17.
 * encrypt[加密]
 */
public class EncryptUtil {
    public static String md5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return s;
    }
}
