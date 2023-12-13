package Topic_5.hw_12;

/**
 * Task_5_2
 * @author Holopura Anna
 */

import java.io.*;

public class Task_5_2
{
    public static void main(String[] args)
    {
        String filePath = "D:/Jav/src/Topic_5/hw_12/File.txt";

        try {
            int emptyLinesCount = countEmptyLines(filePath);
            System.out.println("Number of empty lines: " + emptyLinesCount);

            int maxLineLength = getMaxLineLength(filePath);
            System.out.println("Max length of line: " + maxLineLength);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    private static int countEmptyLines(String filePath) throws IOException
    {
        int emptyLinesCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.trim().isEmpty()) { emptyLinesCount++; }
            }
        }

        return emptyLinesCount;
    }

    private static int getMaxLineLength(String filePath) throws IOException
    {
        int maxLineLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                int lineLength = line.length();
                if (lineLength > maxLineLength)
                {
                    maxLineLength = lineLength;
                }
            }
        }

        return maxLineLength;
    }
}
