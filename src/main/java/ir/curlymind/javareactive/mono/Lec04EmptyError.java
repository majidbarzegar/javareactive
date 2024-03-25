package ir.curlymind.javareactive.mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;

public class Lec04EmptyError {
    public static void main(String[] args) {
        Mono<String> userMono = userRepository(1);
        Mono<String> emptyMono = userRepository(2);
        Mono<String> errorMono = userRepository(3);

        userMono.subscribe(Utils.subscriber("user mono"));
        emptyMono.subscribe(Utils.subscriber("empty mono"));
        errorMono.subscribe(Utils.subscriber("error mono"));
    }

    public static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Utils.faker().name().fullName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("UserId is incorrect"));
        }
    }
}
