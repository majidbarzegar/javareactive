package ir.curlymind.javareactive.sec01mono;

import ir.curlymind.javareactive.Utils;
import reactor.core.publisher.Mono;

public class Lec09Assignment {
    public static void main(String[] args) {

        Mono<Void> write = FileService.write("test.txt", "majid");
        Mono<String> read = FileService.read("test.txt");
        Mono<Void> delete = FileService.delete("test.txt");

        write.subscribe(Utils.subscriber("file write"));
        read.subscribe(Utils.subscriber("file read"));
        delete.subscribe(Utils.subscriber("file delete"));

    }


}
