package ir.curlymind.javareactive.sec11sink;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec05SinkMultiDirectAll {
    public static void main(String[] args) {

//        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Utils.subscriber("majid"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(Utils.subscriber("samane"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Utils.sleepSeconds(30);
    }
}
