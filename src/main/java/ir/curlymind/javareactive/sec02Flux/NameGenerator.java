package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {


    public static List<String> getNameList(int count) {
        List<String> nameList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            nameList.add(getName());
        }
        return nameList;
    }

    public static Flux<String> getNameFlux(int count) {
        return Flux.range(1, count)
                .map(i -> getName());
    }

    private static String getName() {
        Utils.sleepSeconds(1);
        return Utils.faker().name().fullName();
    }
}
