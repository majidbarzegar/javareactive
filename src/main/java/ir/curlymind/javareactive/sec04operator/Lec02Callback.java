package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec02Callback {
    public static void main(String[] args) {
        Flux
                .create(sink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        sink.next(i);
                    }
//                    sink.error(new RuntimeException("oops"));
                    sink.complete();
                    System.out.println("end of create");
                })
                .doFirst(() -> System.out.println("doFirst"))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe: " + subscription))
                .doOnRequest(value -> System.out.println("doOnRequest: " + value))
                .doOnNext(o -> System.out.println("doOnNext: " + o))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnError(throwable -> System.out.println("doOnError: " + throwable.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel")) //
                .doFinally(signalType -> System.out.println("doFinally: " + signalType.name()))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
                .take(2)
                .subscribe(Utils.subscriber());

    }
}
