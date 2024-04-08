package ir.curlymind.javareactive.sec12context;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Context {
    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(context -> context.put("user", context.get("user").toString().toUpperCase()))
                .contextWrite(Context.of("user", "majid"))
                .subscribe(Utils.subscriber());
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}
