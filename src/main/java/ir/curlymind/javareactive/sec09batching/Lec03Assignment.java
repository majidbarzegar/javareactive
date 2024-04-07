package ir.curlymind.javareactive.sec09batching;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {
    public static void main(String[] args) {
        Set<String> allowedCategory = Set.of(
                "Science diction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream()
                .filter(bookOrder -> allowedCategory.contains(bookOrder.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(bookOrders -> revenueCalculator(bookOrders))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }

    private static RevenueReport revenueCalculator(List<BookOrder> books) {
        Map<String, Double> map = books.stream().collect(
                Collectors.groupingBy(
                        BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice))
        );
        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux
                .interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }
}
