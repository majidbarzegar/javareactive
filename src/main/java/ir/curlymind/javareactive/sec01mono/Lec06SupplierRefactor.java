package ir.curlymind.javareactive.sec01mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactor {
    public static void main(String[] args) {

        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic()) // explain in next folder
                .subscribe(Utils.subscriber());
        getName();

        Utils.sleepSeconds(3);
    }

    public static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Utils.sleepSeconds(2);
            return Utils.faker().name().fullName();
        });
    }
}
