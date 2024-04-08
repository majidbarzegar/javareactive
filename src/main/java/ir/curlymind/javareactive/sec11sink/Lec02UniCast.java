package ir.curlymind.javareactive.sec11sink;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02UniCast {
    public static void main(String[] args) {

        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Utils.subscriber("majid"));
        flux.subscribe(Utils.subscriber("samane")); // ERROR : UnicastProcessor allows only a single Subscriber

        sink.tryEmitNext("Hallo");
        sink.tryEmitNext("ich bin majid");
        sink.tryEmitNext("goten tag");

    }
}
