package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec10SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    return signal.isOnNext() && signal.get().getAge() > 15 ?
                            personFlux : applyFilterMap().apply(personFlux);
                })
                .subscribe(Utils.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux
                .range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .doOnNext(person -> {
                    if (person.getAge() > 10) {
                        person.setName(person.getName().toUpperCase());
                    }
                });
    }
}
