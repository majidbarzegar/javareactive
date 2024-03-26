package ir.curlymind.javareactive.sec03flux;

import ir.curlymind.javareactive.Utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec10Assignment {

    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        FileReaderService.read(path)
                .take(20)
                .subscribe(Utils.subscriber());
    }
}
