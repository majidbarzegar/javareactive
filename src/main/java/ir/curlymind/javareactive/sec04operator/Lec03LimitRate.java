package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

public class Lec03LimitRate {
    public static void main(String[] args) {
        Flux
                .range(1, 1000)
                .log()
//                .limitRate(50) // 75%
//                .limitRate(50, 90) // 90%
//                .limitRate(50, 50) // 75%
                .limitRate(50, 0) // 100%
                .subscribe(Utils.subscriber());

    }
}
