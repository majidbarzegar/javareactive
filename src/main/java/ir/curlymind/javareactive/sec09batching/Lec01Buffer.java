package ir.curlymind.javareactive.sec09batching;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {
    public static void main(String[] args) {
        eventStream()
//                .buffer(5)
//                .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux
                .interval(Duration.ofMillis(850))
                .map(i -> "Event " + i);
    }
}
