package ir.curlymind.javareactive.sec04operator;

import reactor.core.publisher.Flux;

public class UserService {
    public static Flux<Person> getPerson() {
        return Flux
                .range(1, 2)
                .map(i -> new Person(i));

    }
}
