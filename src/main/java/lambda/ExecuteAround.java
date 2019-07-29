package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("gradlew"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("gradlew"))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}
