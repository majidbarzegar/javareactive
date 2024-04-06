package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generate() {
        return Flux
                .generate(stringSynchronousSink -> {
                    System.out.println("generate");
                    Utils.sleepSeconds(1);
                    String name = Utils.faker().name().fullName();
                    list.add(name);
                    stringSynchronousSink.next(name);
                })
                .cast(String.class)
                .startWith(getFromCache());
    }

    public Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}
