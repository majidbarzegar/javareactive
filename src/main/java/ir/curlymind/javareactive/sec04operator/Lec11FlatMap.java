package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;

public class Lec11FlatMap {
    public static void main(String[] args) {

        UserService
                .getPerson()
//                .map(person -> OrderService.getOrder(person.getPersonId())) Flux<Flux<PurchaseOrder>>
                .flatMap(person -> OrderService.getOrder(person.getPersonId())) // Flux<PurchaseOrder>
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(6);
    }
}
