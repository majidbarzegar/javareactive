package ir.curlymind.javareactive.sec12context;

import reactor.util.context.Context;

import java.util.Map;
import java.util.function.Function;

public class UserService {
    private static final Map<String, String> MAP = Map.of(
            "majid", "std",
            "samane", "prime"
    );

    public static Function<Context, Context> userCategoryContext() {
        return context -> {
            String user = context.get("user").toString();
            String category = MAP.get(user);
            return context.put("category", category);
        };
    }
}
