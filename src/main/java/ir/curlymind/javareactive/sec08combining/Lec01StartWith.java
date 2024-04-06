package ir.curlymind.javareactive.sec08combining;

import ir.curlymind.javareactive.Utils;

public class Lec01StartWith {
    public static void main(String[] args) {
        var nameGenerator = new NameGenerator();

        nameGenerator
                .generate()
                .take(2)
                .subscribe(Utils.subscriber("majid"));

        System.out.println("-----------------------------");

        nameGenerator
                .generate()
                .take(2)
                .subscribe(Utils.subscriber("samane"));

        System.out.println("-----------------------------");

        nameGenerator
                .generate()
                .take(3)
                .subscribe(Utils.subscriber("hannah"));
    }
}
