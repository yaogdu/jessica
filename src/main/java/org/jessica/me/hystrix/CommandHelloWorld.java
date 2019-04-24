/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the
 * confidential and proprietary information of duolabao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with duolabao.com.
 */
package org.jessica.me.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 类CommandHelloWorld的实现描述：TODO 类实现描述
 *
 * @author yaoguang.du 2018/5/1 01:06
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    protected String run() throws Exception {
        return "hello "+name;
    }
}
