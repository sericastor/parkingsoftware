/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author miguel
 */
public class MD5Security {

    public String MD5Security(String password) {
        try {
            String passMD5 = null;
            byte[] passbyte = password.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(passbyte);
            passMD5 = byteArrToString(md.digest());

            return passMD5;
        } catch (NoSuchAlgorithmException ex) {
            return "Error de seguridad, imposible converitr a MD5";
        }
    }

    private static String byteArrToString(byte[] b) {
        String res = null;
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int j = b[i] & 0xff;
            if (j < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(j));
        }
        res = sb.toString();
        return res.toUpperCase();
    }
}
