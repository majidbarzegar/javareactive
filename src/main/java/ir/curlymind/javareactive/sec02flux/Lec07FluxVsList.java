package ir.curlymind.javareactive.sec02flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {

        List<String> nameList = NameGenerator.getNameList(5);
        System.out.println(nameList);

        Flux<String> nameFlux = NameGenerator.getNameFlux(5);
        nameFlux.subscribe(Utils.subscriber());

    }
}
