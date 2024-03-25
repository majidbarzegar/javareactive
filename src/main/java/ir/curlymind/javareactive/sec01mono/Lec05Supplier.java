package ir.curlymind.javareactive.sec01mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05Supplier {
    public static void main(String[] args) {

        // use << just >> only when you have data already
//        Mono<String> monoJust = Mono.just(getName());

        Supplier<String> supplier = Lec05Supplier::getName;
        Mono<String> monoSupplier = Mono.fromSupplier(supplier);
        monoSupplier.subscribe(Utils.subscriber("from Supplier"));

        Callable<String> callable = Lec05Supplier::getName;
        Mono<String> monoCallable = Mono.fromCallable(callable);
        monoCallable.subscribe(Utils.subscriber("from Callable"));

    }

    public static String getName(){
        System.out.println("Generating name..");
        return Utils.faker().name().fullName();
    }
}
