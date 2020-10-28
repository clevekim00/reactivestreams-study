package com.clevekim.study.reactivestreams.impl;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by younghwan.kim@linecorp.com on 2020-10-28
 */
public class ClevekimPublisher implements Publisher<Integer> {

    private Logger logger = LoggerFactory.getLogger(ClevekimPublisher.class);

    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {

        logger.info("ClevekimPublisher : " + subscriber);

        subscriber.onSubscribe(new ClevekimSubscription(executor, subscriber));
    }
}
