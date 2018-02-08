package com.cjzf.security;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName Encrypt
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Slf4j
public class Encrypt {
    private static final Logger log = LoggerFactory.getLogger(Encrypt.class);
    
    
    public static void main(String[] args) {
        //securityVerify();
    }

    /**
     * 检查java8的JCE是否在本机mac系统安装成功
     */
    private static void securityVerify() {
        byte[] data = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};
        // create a 64 bit secret key from raw bytes
        SecretKey key64 = new SecretKeySpec(
                new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07},
                "Blowfish");

        try {// create a cipher and attempt to encrypt the data block with our key
            Cipher c = Cipher.getInstance("Blowfish/ECB/NoPadding");
            c.init(Cipher.ENCRYPT_MODE, key64);
            c.doFinal(data);
            log.info("64 bit test: passed");

            // create a 192 bit secret key from raw bytes
            SecretKey key192 = new SecretKeySpec(
                    new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                            0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f,
                            0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17},
                    "Blowfish");

            // now try encrypting with the larger key
            c.init(Cipher.ENCRYPT_MODE, key192);
            c.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            log.error("exception message is:{}", e.getMessage());
        }

        log.info("192 bit test: passed");
        log.info("Tests completed");
    }
}