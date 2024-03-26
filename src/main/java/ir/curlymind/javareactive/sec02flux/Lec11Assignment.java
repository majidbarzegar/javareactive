package ir.curlymind.javareactive.sec02flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Lec11Assignment {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        StockPricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Subscription:" + subscription);
                        subscription.request(Long.MAX_VALUE);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received : " + integer);
                        if (integer > 110 || integer < 90) {
                            atomicReference.get().cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("ERROR : " + throwable.getMessage());
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                        latch.countDown();
                    }
                });
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
