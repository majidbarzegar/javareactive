package ir.curlymind.javareactive.sec12context;

import ir.curlymind.javareactive.Utils;
import reactor.util.context.Context;

public class Lec02RateLimiter {
    public static void main(String[] args) {
        BookService.getBook()
                .repeat(10)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "majid"))
                .subscribe(Utils.subscriber());
    }
}
