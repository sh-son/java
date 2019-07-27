package lambda;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BufferedReaderProcessorTest {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                new BufferedReader(new FileReader("gradlew"))) {
            return p.process(br);
        }
    }

    @Test
    public void testProcessFile() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }


}