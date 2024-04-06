package ir.curlymind.javareactive.sec05publisher;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

public class OrderService {

    private Flux<PurchaseOrder> flux;

    public Flux<PurchaseOrder> orderStream() {
        if (Objects.isNull(flux)) {
            flux = getOrderService();
        }
        return flux;
    }


    private Flux<PurchaseOrder> getOrderService() {
        return Flux
                .interval(Duration.ofMillis(100))
                .map(i -> new PurchaseOrder())
                .publish()
                .refCount(2);

    }
}
