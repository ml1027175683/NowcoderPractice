package com.h9.dododododod;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.XML;
import com.h9.dododododod.rtz.JaxbUtil;
import com.h9.dododododod.rtz.Waypoints;
import com.h9.dododododod.xmlJavaBean.JsonRootBean;
import com.h9.dododododod.xmlJavaBean.Route;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.core.MessageProducer;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SpringBootTest
class H9DodododododApplicationTests {

    @Test
    void fun3() {
        String path = "C:\\Users\\Administrator\\Desktop\\xxx\\01-31.xml";

        String xmlStr = FileUtil.readString(path, "UTF-8");

        JSONObject jsonObject = XML.toJSONObject(xmlStr);


        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");



    }

    @Test
    void fun2() {
        String str="0.1";
        if (NumberUtil.isDouble(str)) {
            System.out.println("double");
        }else {
            System.out.println("int");
        }
    }


    @Test
    void fun1() {
        // 读取 XML 文件
        String path = "C:\\Users\\Administrator\\Desktop\\PACIFIC EXPRESS 2202-C PONTA DA MADEIRA-SHULANGHU-Revised - 副本.xml";
        String xmlStr = FileUtil.readString(path, "UTF-8");

        JSONObject jsonObject = XML.toJSONObject(xmlStr);
        JsonRootBean bean = JSONUtil.toBean(JSONUtil.toJsonStr(jsonObject), JsonRootBean.class);


        System.out.println(bean);
    }


}
