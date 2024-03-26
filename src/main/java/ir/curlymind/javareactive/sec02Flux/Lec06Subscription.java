package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {

        Flux<Integer> fluxRange = Flux.range(1, 10);
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        fluxRange
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Subscription: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received : " + integer);
            /*    if(integer == 2){
                    atomicReference.get().cancel();
                }*/
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("ERROR : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });

        Utils.sleepSeconds(2);
        atomicReference.get().request(1);
        Utils.sleepSeconds(2);
        atomicReference.get().request(2);
        Utils.sleepSeconds(2);
        atomicReference.get().request(3);
        Utils.sleepSeconds(2);
        atomicReference.get().cancel();
        Utils.sleepSeconds(2);
    }
}
