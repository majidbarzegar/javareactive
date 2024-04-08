package ir.curlymind.javareactive.sec11sink;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {
    public static void main(String[] args) {

//        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();

        Flux<Object> flux = sink.asFlux();


        sink.tryEmitNext("Hallo");
        flux.subscribe(Utils.subscriber("majid"));
        sink.tryEmitNext("ich bin majid");
        flux.subscribe(Utils.subscriber("samane"));
        sink.tryEmitNext("goten tag");
        flux.subscribe(Utils.subscriber("hannah"));
        sink.tryEmitNext("ich male");

    }
}
