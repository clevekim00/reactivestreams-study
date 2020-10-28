package com.clevekim.study.reactivestreams.impl;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by younghwan.kim@linecorp.com on 2020-10-28
 */
public class ClevekimSubscription implements Subscription {

    private Logger logger = LoggerFactory.getLogger(ClevekimSubscription.class);

    private final ExecutorService executor;
    private final Subscriber subscriber;
    private final AtomicInteger value;

    public ClevekimSubscription(ExecutorService executor, Subscriber subscriber) {
        this.executor = executor;
        this.subscriber = subscriber;

        this.value = new AtomicInteger();
    }

    @Override
    public void request(long n) {

        logger.info("request:" + n);

        if (n < 0) {
            subscriber.onError(new IllegalArgumentException("n is must positive"));
            return;
        }

        for (long i = 0L; i < n; i++) {
            executor.execute(() -> {
                int count = value.incrementAndGet();
                if (count >= n) {
                    subscriber.onComplete();
                } else {
                    subscriber.onNext(count);
                }
            });
        }
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
