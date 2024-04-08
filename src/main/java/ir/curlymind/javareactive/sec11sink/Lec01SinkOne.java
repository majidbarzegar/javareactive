package ir.curlymind.javareactive.sec11sink;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {
    public static void main(String[] args) {
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();
        mono.subscribe(Utils.subscriber("majid"));
        mono.subscribe(Utils.subscriber("curly"));

        sink.tryEmitValue("hallo!");
//        sink.tryEmitEmpty();
//        sink.tryEmitError(new RuntimeException("oops"));

//        sink.emitValue("Hallo!", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });
//
//        sink.emitValue("ich bin majid!", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return true;
//        });


    }
}
