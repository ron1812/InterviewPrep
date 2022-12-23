package com.practice.core;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReadWays {

    /*
    As we saw how to read a large file in Java efficiently. Few things which you need to pay close attention

    Reading the large file in one go will not be a good option (You will get OutOfMemoryError ).
    We Adapted technique to read large file line by line to keep memory footprint low.
    I used VisualVM to monitoring Memory, CPU and Threadpool information while running these programmes.

    based on our test, BufferReader has the lowest memory footprint, though the overall execution was slow.
     */
    public static void main(String[] args) throws FileNotFoundException,IOException {

        // ***********   Using Java BufferReader **********************************

        String fileName = "/tutorials/fileread/file.txt";
        try (BufferedReader fileBufferReader = new BufferedReader(new FileReader(fileName))) {
            String fileLineContent;
            while ((fileLineContent = fileBufferReader.readLine()) != null) {
                System.out.println(fileLineContent);
            }
        }



        // ************* Using Java 8 Stream API *********************

        // lines(Path path, Charset cs)
        try (Stream inputStream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            inputStream.forEach(System.out::println);
        }

        // ************* Using Java Scanner *********************

        InputStream inputStream = new FileInputStream(fileName);

        try(Scanner fileScanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())){
            while (fileScanner.hasNextLine()){
                System.out.println(fileScanner.nextLine());
            }
        }

        // ************* Streaming File Using Apache Commons IO *********************

//        LineIterator fileContents= FileUtils.lineIterator(new File(fileName), StandardCharsets.UTF_8.name());
//        while(fileContents.hasNext()){
//            System.out.println(fileContents.nextLine());
//        }

    }
}
