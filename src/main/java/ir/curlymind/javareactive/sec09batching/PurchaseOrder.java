package ir.curlymind.javareactive.sec09batching;

import ir.curlymind.javareactive.Utils;
import lombok.Data;

@Data
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = Utils.faker().commerce().productName();
        this.price = Double.parseDouble(Utils.faker().commerce().price());
        this.category = Utils.faker().commerce().department();
    }
}
