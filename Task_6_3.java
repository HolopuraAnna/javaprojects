package Topic_5.hw_12;

/**
 * Task_6_3
 * @author Holopura Anna
 */

import java.io.*;

public class Task_6_3
{
    public static void main(String[] args)
    {
        String inputFilePath = "D:/Jav/src/Topic_5/hw_12/File1.txt";
        String outputFilePath = "D:/Jav/src/Topic_5/hw_12/File2.txt";

        try {
            long product = 1;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0) { product *= number; }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)))
            {
                writer.write("Product of even nubers: " + product);
            }
        }
        catch (IOException e) { e.printStackTrace(); }
    }
}
