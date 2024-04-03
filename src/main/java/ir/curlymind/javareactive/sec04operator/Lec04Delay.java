package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "9");
        Flux
                .range(1, 100) //request(9) default is 32 in Queues class
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }
}
