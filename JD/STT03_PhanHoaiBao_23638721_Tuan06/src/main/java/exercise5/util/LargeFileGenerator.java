package exercise5.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LargeFileGenerator {

    public static void generateSampleTextFile(File targetFile, int targetSizeMB) throws IOException {
        long targetBytes = (long) targetSizeMB * 1024 * 1024;
        long writtenBytes = 0;
        int lineCounter = 1;

        String[] sampleSentences = {
                "Distributed Programming With Java - Faculty of Information Technology, IUH.\n",
                "Chapter 1: Multi-threading and Concurrency in Java SE.\n",
                "Testing multithreaded file loading with a large file to ensure UI responsiveness.\n",
                "SwingWorker prevents EDT freeze by running heavy I/O operations on worker threads.\n",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.\n"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile), 64 * 1024)) {
            while (writtenBytes < targetBytes) {
                String sentence = sampleSentences[lineCounter % sampleSentences.length];
                String line = String.format("[%07d] %s", lineCounter++, sentence);
                writer.write(line);
                writtenBytes += line.getBytes().length;
            }
            writer.flush();
        }
    }

    public static void main(String[] args) {
        File file = new File("sample_20MB.txt");
        System.out.println("Generating 20MB test file at: " + file.getAbsolutePath());
        try {
            generateSampleTextFile(file, 20);
            System.out.printf("Done! Created %s (%d bytes).%n", file.getName(), file.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
