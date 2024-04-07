package ir.curlymind.javareactive.sec10repeatretry;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class Lec04RetryWhenAdvanced {

    public static void main(String[] args) {
        orderService(Utils.faker().business().creditCardNumber())
                .retryWhen(Retry.from(
                        flux -> flux
                                .doOnNext(rs -> {
                                    System.out.println(rs.totalRetries());
                                    System.out.println(rs.failure());
                                })
                                .handle((rs, sink) -> {
                                    if (rs.failure().getMessage().equals("500")) {
                                        sink.next("99999");
                                    } else {
                                        sink.error(rs.failure());
                                    }
                                })
                                .delayElements(Duration.ofSeconds(1))
                ))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return Utils.faker().idNumber().valid();
        });
    }

    private static void processPayment(String ccNumber) {
        int random = Utils.faker().random().nextInt(1, 10);
        if (random < 8) {
            throw new RuntimeException("500");
        } else if (random < 10) {
            throw new RuntimeException("404");
        }
    }
}
