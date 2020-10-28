package com.clevekim.study.reactivestreams;

import com.clevekim.study.reactivestreams.impl.ClevekimPublisher;
import com.clevekim.study.reactivestreams.impl.ClevekimSubscriber;
import org.omg.PortableInterceptor.INACTIVE;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivestreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivestreamsApplication.class, args);

		Publisher<Integer> publisher = new ClevekimPublisher();
		Subscriber<Integer> subscriber = new ClevekimSubscriber();
		publisher.subscribe(subscriber);
	}

}
