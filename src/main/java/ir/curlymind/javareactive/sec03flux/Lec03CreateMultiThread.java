package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec03CreateMultiThread {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux
                .create(nameProducer)
                .subscribe(Utils.subscriber());
        Runnable runnable = nameProducer::produceMultiThread;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
