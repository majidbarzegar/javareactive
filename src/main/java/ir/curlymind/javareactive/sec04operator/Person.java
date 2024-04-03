package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
    private int personId;

    public Person() {
        this.name = Utils.faker().name().fullName();
        this.age = Utils.faker().random().nextInt(1, 30);
    }

    public Person(int personId) {
        this.name = Utils.faker().name().fullName();
        this.personId = personId;
    }
}
