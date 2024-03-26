package ir.curlymind.javareactive.sec02flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02MultipleSubscriber {
    public static void main(String[] args) {

        Flux<Integer> fluxJust = Flux.just(1, 2, 3, 4, 5);

        fluxJust
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Utils.subscriber("first"));
        fluxJust
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Utils.subscriber("second"));

        Flux<Integer> evenFlux = fluxJust.filter(i -> i % 2 == 0);
        evenFlux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Utils.subscriber("even"));

        Utils.sleepSeconds(5);
    }
}
