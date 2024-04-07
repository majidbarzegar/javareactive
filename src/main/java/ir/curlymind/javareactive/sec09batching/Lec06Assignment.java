package ir.curlymind.javareactive.sec09batching;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.function.Function;

public class Lec06Assignment {
    public static void main(String[] args) {

        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
                "Kids", OrderProcessor.kidsProcessing(),
                "Automotive", OrderProcessor.automotiveProcessing()
        );

        OrderService
                .orderStream()
                .filter(p -> map.containsKey(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }
}
