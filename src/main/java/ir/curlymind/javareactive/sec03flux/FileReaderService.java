package ir.curlymind.javareactive.sec03flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    public static Flux<String> read(Path path) {
        return Flux.generate(
                openReader(path),
                readFile(),
                closeReader()
        );
    }

    public static Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    public static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> readFile() {
        return (bufferedReader, sink) -> {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                sink.error(new RuntimeException("IOException in file reading"));
            }
            if (line != null) {
                sink.next(line);
            } else {

                sink.complete();
            }
            return bufferedReader;
        };
    }

    public static Consumer<BufferedReader> closeReader() {
        return bufferedReader -> {
            try {
                System.out.println("reader closed");
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
