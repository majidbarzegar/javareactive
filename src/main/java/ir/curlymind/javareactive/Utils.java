package ir.curlymind.javareactive;

import org.reactivestreams.Subscriber;

import java.util.function.Consumer;
import com.github.javafaker.Faker;


public class Utils {

    private static final Faker FAKER = Faker.instance();

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleepSeconds(int seconds){
        sleepMillis(seconds * 1000);
    }

    public static void sleepMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("Error: " + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Complete");
    }


}
