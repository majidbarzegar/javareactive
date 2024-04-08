package ir.curlymind.javareactive.sec11sink;

import lombok.Data;

@Data
public class SlackMessage {
    private static final String FORMAT = "[%s -> %s] : %s";
    private String senderName;
    private String receiverName;
    private String message;

    public String toString() {
        return String.format(FORMAT, this.senderName, this.receiverName, this.message);
    }
}
