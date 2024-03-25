package ir.curlymind.javareactive.mono;

import ir.curlymind.javareactive.Utils;

public class Lec05Supplier {
    public static void main(String[] args) {

    }

    public static String getName(){
        System.out.println("Generating name..");
        return Utils.faker().name().fullName();
    }
}
