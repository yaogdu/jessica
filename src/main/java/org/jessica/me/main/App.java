/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the
 * confidential and proprietary information of duolabao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with duolabao.com.
 */
package org.jessica.me.main;

import org.jessica.me.hystrix.CmdHelloWorld2;
import org.jessica.me.hystrix.CommandHelloWorld;
import org.springframework.stereotype.Service;
import rx.Observable;

/**
 * 类App的实现描述：TODO 类实现描述
 *
 * @author yaoguang.du 2018/1/6 22:40
 */
@Service
public class App {

    public static void main(String[] args) {
//        App app = new App();
//        app.sayHello();
//
//        synchronized (App.class) {
//            while (true) {
//                try {
//                    App.class.wait();
//                } catch (Throwable e) {
//
//                }
//            }
//        }

        String s = new CommandHelloWorld("Bob").execute();

        System.out.println(s);

        Observable<String> o = new CommandHelloWorld("Toby").observe();


        System.out.println(o);

        Observable<String> o2 = new CmdHelloWorld2("wo").observe();


    }



    public void sayHello() {
        System.out.println(App.class.getName());
    }
}
