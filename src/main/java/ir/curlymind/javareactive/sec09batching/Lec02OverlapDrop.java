package ir.curlymind.javareactive.sec09batching;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02OverlapDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(3, 1)
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux
                .interval(Duration.ofMillis(300))
                .map(i -> "Event " + i);
    }
}
