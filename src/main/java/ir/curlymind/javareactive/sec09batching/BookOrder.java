package ir.curlymind.javareactive.sec09batching;

import com.github.javafaker.Book;
import ir.curlymind.javareactive.Utils;
import lombok.Data;

@Data
public class BookOrder {
    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder() {
        Book book = Utils.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(Utils.faker().commerce().price());
    }
}
