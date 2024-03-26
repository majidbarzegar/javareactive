package ir.curlymind.javareactive.sec02flux;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04Stream {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();

        Flux<Integer> fluxStream = Flux.fromStream(stream);

        fluxStream.subscribe(Utils.subscriber("first"));
        fluxStream.subscribe(Utils.subscriber("second"));

    }

}
