package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec02Create {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux
                .create(nameProducer)
                .subscribe(Utils.subscriber());
        nameProducer.produce();
    }
}
