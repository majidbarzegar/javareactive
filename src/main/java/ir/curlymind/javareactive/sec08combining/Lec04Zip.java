package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(
                getBody(),
                getEngine(),
                getTires()
        ).subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static Flux<String> getBody() {
        return Flux
                .range(1, 5)
                .map(integer -> "Body");
    }

    private static Flux<String> getEngine() {
        return Flux
                .range(1, 3)
                .map(integer -> "Engine");
    }

    private static Flux<String> getTires() {
        return Flux
                .range(1, 10)
                .map(integer -> "Tires");
    }
}
