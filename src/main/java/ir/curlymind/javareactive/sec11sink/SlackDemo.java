package ir.curlymind.javareactive.sec11sink;

import ir.curlymind.javareactive.Utils;

public class SlackDemo {
    public static void main(String[] args) {

        SlackRoom room = new SlackRoom("MajidSamaneChat");

        SlackMember majid = new SlackMember("majid");
        SlackMember samane = new SlackMember("samane");
        SlackMember hannah = new SlackMember("hannah");

        room.joinRoom(majid);
        room.joinRoom(samane);

        majid.says("Hallo all ...");
        Utils.sleepSeconds(4);

        samane.says("Hallo!");
        majid.says("ich bin majid");
        Utils.sleepSeconds(4);

        room.joinRoom(hannah);
        hannah.says("hallo ich bin hannah");
    }
}
