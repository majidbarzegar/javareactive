package ir.curlymind.javareactive.sec04operator;

import ir.curlymind.javareactive.Utils;
import lombok.Data;

@Data
public class PurchaseOrder {
    private String item;
    private String price;
    private int personId;

    public PurchaseOrder(int personId) {
        this.personId = personId;
        this.item = Utils.faker().commerce().productName();
        this.price = Utils.faker().commerce().price();
    }
}
