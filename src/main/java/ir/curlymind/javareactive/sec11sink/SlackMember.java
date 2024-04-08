package ir.curlymind.javareactive.sec11sink;

import java.util.function.Consumer;

public class SlackMember {
    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

    public void receives(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        messageConsumer.accept(message);
    }

    public String getName() {
        return name;
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
}
