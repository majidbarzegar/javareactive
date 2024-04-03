package ir.curlymind.javareactive.sec04operator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

    static {
        List<PurchaseOrder> list1 = List.of(
                new PurchaseOrder(1),
                new PurchaseOrder(1),
                new PurchaseOrder(1)
        );
        List<PurchaseOrder> list2 = List.of(
                new PurchaseOrder(2),
                new PurchaseOrder(2),
                new PurchaseOrder(2)
        );

        db.put(1, list1);
        db.put(2, list2);
    }

    public static Flux<PurchaseOrder> getOrder(int personId) {
        return Flux
                .create((FluxSink<PurchaseOrder> fluxSink) -> {
                    db.get(personId).forEach(fluxSink::next);
                    fluxSink.complete();
                })
                .delayElements(Duration.ofSeconds(1));
    }
}
