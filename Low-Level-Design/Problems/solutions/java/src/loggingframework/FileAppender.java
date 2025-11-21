package loggingframework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAppender implements LogAppender {
    private final String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(LogMessage message) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}
