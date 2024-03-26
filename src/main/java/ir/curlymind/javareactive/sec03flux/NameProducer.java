package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        this.fluxSink.next(Utils.faker().name().fullName());
    }

    public void produceMultiThread() {
        String name = Utils.faker().name().fullName();
        String threadName = Thread.currentThread().getName();
        this.fluxSink.next(threadName + " : " + name);
    }
}
