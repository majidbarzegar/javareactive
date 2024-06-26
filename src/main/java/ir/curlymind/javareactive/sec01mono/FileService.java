package ir.curlymind.javareactive.sec01mono;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    public static void writeFile(String fileName, String content) {
        try {
            Files.writeString(PATH.resolve(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String fileName) {
        try {
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> {
            System.out.println("start to write file");
            writeFile(fileName, content);
        });
    }

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> {
            System.out.println("start to write file");
            return readFile(fileName);
        });
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> {
            System.out.println("start to write file");
            deleteFile(fileName);
        });
    }
}
