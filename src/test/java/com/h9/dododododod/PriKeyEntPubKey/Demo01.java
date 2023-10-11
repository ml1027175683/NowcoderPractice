package com.h9.dododododod.PriKeyEntPubKey;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootTest
public class Demo01 {

    @Test
    public  void fun5(){

        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(map.size());

    }

    @Test
    public void fun4() {
        // UTC-9:30
        ZoneOffset offset930 = ZoneOffset.ofHoursMinutes(-9, -30);
        OffsetDateTime dateTime930 = OffsetDateTime.now(offset930);
        System.out.println("UTC-9:30：" + dateTime930);

        // UTC-9:00
        ZoneOffset offset900 = ZoneOffset.ofHours(-9);
        OffsetDateTime dateTime900 = OffsetDateTime.now(offset900);
        System.out.println("UTC-9:00：" + dateTime900);

        // UTC-8:00
        ZoneOffset offset800 = ZoneOffset.ofHours(-8);
        OffsetDateTime dateTime800 = OffsetDateTime.now(offset800);
        System.out.println("UTC-8:00：" + dateTime800);

        // UTC-7:00
        ZoneOffset offset700 = ZoneOffset.ofHours(-7);
        OffsetDateTime dateTime700 = OffsetDateTime.now(offset700);
        System.out.println("UTC-7:00：" + dateTime700);

        // UTC-7:00
        ZoneOffset offset0 = ZoneOffset.ofHours(-0);
        OffsetDateTime dateTime0 = OffsetDateTime.now(offset0);
        System.out.println("UTC-0：" + dateTime0);
        // UTC-7:00
        ZoneOffset offset8 = ZoneOffset.ofHours(8);
        OffsetDateTime dateTime8 = OffsetDateTime.now(offset8);
        System.out.println("UTC-0：" + dateTime8);


    }

    public static void main(String[] args) {

        String s1 = formatDateToUTC(new Date(), 1);
        System.out.println(s1);
    }


    public static final String FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static String formatDateToUTC(Date date, int amout) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_UTC);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, amout);

        return dateFormat.format(calendar.getTime());
    }


    @Test
    void contextLoads() throws Exception {

        PrivateKey privateKey = null;
        PublicKey publicKey = null;

        try {
            //公私钥生成
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = new SecureRandom();
            keyGen.initialize(2048, random);
            KeyPair pair = keyGen.generateKeyPair();


            PrivateKey privateKey1 = pair.getPrivate();
            PublicKey publicKey1 = pair.getPublic();


            //   String privateKeyJson = JSONUtil.toJsonStr(privateKey);
            //   String publicKeyJson = JSONUtil.toJsonStr(publicKey);

            // 写入私钥
            FileOutputStream privateFos = new FileOutputStream("private_key.der");
            privateFos.write(privateKey1.getEncoded());
            privateFos.close();
            System.out.println("=========生成公钥文件=========");
            // 写入公钥
            FileOutputStream publicFos = new FileOutputStream("public_key.der");
            publicFos.write(publicKey1.getEncoded());
            publicFos.close();
            System.out.println("=========生成私钥文件=========");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //根据加解密文件 获取 私钥公钥对象

        privateKey = getPrivateKey();
        publicKey = getPublicKey();
        //使用公钥加密数据
        byte[] cipherText = getBytes(publicKey);
        //使用私钥解密数据
        String result = getString(privateKey, cipherText);

        System.out.println(result);

    }

    private static byte[] getBytes(PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String data = "cpumac:1213,netmac:123";
        System.out.println("");
        System.out.println(" ============加密=============");
        System.out.println(" 加密数据:" + data);
        System.out.println(" ============================");
        byte[] plainText = data.getBytes();
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plainText);
        return cipherText;
    }

    private static String getString(PrivateKey privateKey, byte[] cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedText = decryptCipher.doFinal(cipherText);
        String result = new String(decryptedText);

        System.out.println("");
        System.out.println(" ============解密=============");
        System.out.println(" 解密数据:" + result);
        System.out.println(" ============================");
        return result;
    }


    private static PublicKey getPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        PublicKey publicKey;
        Path path = Paths.get("public_key.der");

        System.out.println("");
        System.out.println(" =========公钥文件地址=========");
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(" =========加载公钥文件=========");
        System.out.println(" ============================");

        byte[] keyBytes = Files.readAllBytes(path);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        publicKey = keyFactory.generatePublic(spec);
        return publicKey;
    }

    private static PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        PrivateKey privateKey;
        Path path = Paths.get("private_key.der");
        System.out.println("");
        System.out.println(" =========私钥文件地址=========");
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(" =========加载公钥文件=========");
        System.out.println(" ============================");
        byte[] keyBytes = Files.readAllBytes(path);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        privateKey = keyFactory.generatePrivate(spec);
        return privateKey;
    }
}
