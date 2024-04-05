package ir.curlymind.javareactive.sec05publisher;

import ir.curlymind.javareactive.Utils;

public class Lec06Assignment {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        RevenueService revenueService = new RevenueService();
        OrderService orderService = new OrderService();

        orderService.orderStream().subscribe(revenueService.subscriptionOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscriptionOrderStream());

        inventoryService
                .inventoryStream()
                .subscribe(Utils.subscriber("inventory"));

        revenueService
                .revenueStream()
                .subscribe(Utils.subscriber("revenue"));

        Utils.sleepSeconds(60);
    }
}
