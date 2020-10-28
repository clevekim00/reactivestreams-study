package com.clevekim.study.reactivestreams.impl;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by younghwan.kim@linecorp.com on 2020-10-28
 */
public class ClevekimSubscriber implements Subscriber<Integer> {

    private Logger logger = LoggerFactory.getLogger(ClevekimSubscriber.class);

    private int count;
    private int DEMEND = 3;
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {

        logger.info("- onSubscribe");
        this.subscription = s;
        this.subscription.request(DEMEND);
    }

    @Override
    public void onNext(Integer integer) {

        logger.info("- onNext : " + integer);
    }

    @Override
    public void onError(Throwable t) {

        logger.info("- onError");
        t.printStackTrace(System.err);
    }

    @Override
    public void onComplete() {

        logger.info("- onComplete");
    }
}
