/*
 * Copyright 2013-2015 duolabao.com All right reserved. This software is the
 * confidential and proprietary information of duolabao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with duolabao.com.
 */
package org.jessica.me.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * 类CmdHelloWorld2的实现描述：TODO 类实现描述
 *
 * @author yaoguang.du 2018/5/1 12:17
 */
public class CmdHelloWorld2 extends HystrixObservableCommand<String> {

    private final String name;

    public CmdHelloWorld2(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;

    }

    protected Observable<String> construct() {

        return Observable.create(new Observable.OnSubscribe<String>() {

            public void call(Subscriber<? super String> subscriber) {
                try {
                    if(!subscriber.isUnsubscribed()){
                        subscriber.onNext("hello");
                        subscriber.onNext(name + "!");
                        subscriber.onCompleted();
                    }
                }catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
