package ir.curlymind.javareactive.sec05publisher;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotShare {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux
                .fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share();

        movieStream.subscribe(Utils.subscriber("majid"));
        Utils.sleepSeconds(5);

        movieStream.subscribe(Utils.subscriber("samane"));

        Utils.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("get the movie streaming request");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8"
        );
    }
}
