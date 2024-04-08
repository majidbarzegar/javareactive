package ir.curlymind.javareactive.sec11sink;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
    private String name;
    private Sinks.Many<SlackMessage> sink;
    private Flux<SlackMessage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joinRoom(SlackMember member) {
        System.out.println(member.getName() + "--- Joined ---" + this.name);
        this.subscribe(member);
        member.setMessageConsumer(message -> {
            this.postMessage(message, member);
        });
    }

    private void subscribe(SlackMember member) {
        this.flux
                .filter(message -> !message.getSenderName().equals(member.getName()))
                .doOnNext(message -> message.setReceiverName(member.getName()))
                .map(SlackMessage::toString)
                .subscribe(member::receives);
    }

    private void postMessage(String message, SlackMember sender) {
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setMessage(message);
        slackMessage.setSenderName(sender.getName());
        this.sink.tryEmitNext(slackMessage);
    }
}
