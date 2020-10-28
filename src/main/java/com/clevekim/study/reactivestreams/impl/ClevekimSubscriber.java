package com.clevekim.study.reactivestreams.impl;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by younghwan.kim@linecorp.com on 2020-10-28
 */
public class ClevekimSubscriber implements Subscriber<Integer> {

    private int count;
    private int DEMEND = 3;
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {

        System.out.println("ClevekimSubscriber - onSubscribe");
        this.subscription = s;
        this.subscription.request(DEMEND);
    }

    @Override
    public void onNext(Integer integer) {

        System.out.println("ClevekimSubscriber - onNext : " + integer);
    }

    @Override
    public void onError(Throwable t) {

        System.out.println("ClevekimSubscriber - onError");
        t.printStackTrace(System.err);
    }

    @Override
    public void onComplete() {

        System.out.println("ClevekimSubscriber - onComplete");
    }
}
