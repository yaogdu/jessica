/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the
 * confidential and proprietary information of duolabao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with duolabao.com.
 */
package org.jessica.me.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类Converter的实现描述：TODO 类实现描述
 *
 * @author yaoguang.du 2018/1/13 11:15
 */
public final class Converter {


    public final int x =0;

    public int y = 0;




    public static <S, T> List<T> convert(List<S> source, Class<T> targetClazz) {

        List<T> result = new ArrayList<T>(source.size());

        //loop source list
        for (S s : source) {

            T t  = (T)s;
            result.add(t);
        }

        return result;
    }


    public static void main(String[] args) {

        List<Integer> source = new ArrayList<Integer>();

        source.add(1);
        source.add(2);
        source.add(3);


        List<String> result = convert(source, String.class);

        System.out.println(result);

    }


}
