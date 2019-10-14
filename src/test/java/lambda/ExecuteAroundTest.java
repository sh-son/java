package lambda;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static lambda.ExecuteAround.processFile;
import static lambda.ExecuteAround.processFileLimited;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExecuteAroundTest {

    @Test
    public void testBufferedReader() throws IOException {

        String result = processFileLimited();
        assertNotNull(result);

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        assertNotNull(oneLine);

        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        assertNotNull(twoLines);
    }
}