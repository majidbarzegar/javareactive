package ir.curlymind.javareactive.sec02Flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03ArrayList {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4);
        Flux.fromIterable(list).subscribe(Utils.subscriber("list"));

        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array).subscribe(Utils.subscriber("array"));

    }
}
