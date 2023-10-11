package com.h9.dododododod.datasend;


import cn.hutool.json.JSONUtil;
import com.h9.dododododod.util.FileUtil;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;


public class Demo01 {

    public static void main(String[] args) throws Exception {

        boolean reachable1 = InetAddress.getByName("www.baidu.com").isReachable(1);
      if (reachable1){
          System.out.println(reachable1);
      }



        String jarPath = getJarPath();

        try {

            Map<String, String> stringStringMap = parseJsonFileFromClassPath("tg.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getJarPath() {
        String path = (new ApplicationHome(FileUtil.class)).getSource().getParentFile().toString();
        return path;
    }

    public static Map<String, String> parseJsonFileFromClassPath(String filename) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(filename);
        String json = jsonFileReader(classPathResource.getInputStream());
        Map bean = JSONUtil.toBean(json, Map.class);
        return bean;
    }

    private static String jsonFileReader(InputStream inputStream) {
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();

        try {
            scanner = new Scanner(inputStream, "utf-8");

            while(scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }

        }

        return buffer.toString();
    }

}
