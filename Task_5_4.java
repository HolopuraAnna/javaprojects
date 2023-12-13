package Topic_5.hw_12;

/**
 * Task_5_4
 * @author Holopura Anna
 */

import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Task_5_4
{
    public static void main(String[] args)
    {
        Path inputFilePath = Paths.get("D:/Jav/src/Topic_5/hw_12/File1.txt");
        Path outputFilePath = Paths.get("D:/Jav/src/Topic_5/hw_12/File2.txt");

        change0To1(inputFilePath, outputFilePath);
        //change1To0(inputFilePath, outputFilePath);
        //reverseLines(inputFilePath, outputFilePath);
    }

    public static void change0To1(Path inputFilePath, Path outputFilePath)
    {
        try {
            List<String> lines = Files.readAllLines(inputFilePath);

            for (int i = 0; i < lines.size(); i++)
            {
                lines.set(i, lines.get(i).replace("0", "1"));
            }

            Files.write(outputFilePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void change1To0(Path inputFilePath, Path outputFilePath)
    {
        try {
            List<String> lines = Files.readAllLines(inputFilePath);

            for (int i = 0; i < lines.size(); i++)
            {
                lines.set(i, lines.get(i).replace("1", "0"));
            }

            Files.write(outputFilePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void reverseLines(Path inputFilePath, Path outputFilePath)
    {
        try {
            List<String> lines = Files.readAllLines(inputFilePath);

            for (int i = 0; i < lines.size(); i++)
            {
                String reversedLine = new StringBuilder(lines.get(i)).reverse().toString();
                lines.set(i, reversedLine);
            }

            Files.write(outputFilePath, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch (IOException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
