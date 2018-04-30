/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the
 * confidential and proprietary information of duolabao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with duolabao.com.
 */
package org.jessica.me.utils;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * 类AnnoHandler的实现描述：TODO 类实现描述
 *
 * @author yaoguang.du 2018/5/1 00:00
 */
public class AnnoHandler {

    private final Class clazz = Service.class;

    private final String anno = "@ThriftField";

    public <T> void handle(Class clz, String path) {

        Annotation[] annotations = clz.getAnnotations();

        //目标类是否有注解
        if (annotations == null || annotations.length <= 0) {
            throw new RuntimeException("没有注解");
        }

        //是否有目标注解
        boolean found = false;

        //循环
        for (Annotation annotation : annotations) {

            if (annotation.annotationType() == clazz) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new RuntimeException("没有找到相应注解" + clazz.toString());
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String tmpLine = null;

            StringBuffer sb = new StringBuffer("");

            int i = 1;

            while ((tmpLine = reader.readLine()) != null) {

                if (tmpLine.contains(" get")) {
                    tmpLine = "    " + anno + "(" + i++ + ") \n" + tmpLine;
                }

                if (tmpLine.contains(" set")) {
                    tmpLine = "    " + anno + " \n" + tmpLine;
                }

                sb.append(tmpLine + "\n");

            }

            reader.close();

            System.out.println(sb.toString());


        } catch (FileNotFoundException e) {
            System.out.println("读取文件异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取文件异常");
            e.printStackTrace();
        }


    }

}
