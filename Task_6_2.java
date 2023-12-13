package Topic_5.hw_12;

/**
 * Task_6_2
 * @author Holopura Anna
 */

import java.io.*;

public class Task_6_2
{
    public static void main(String[] args)
    {
        String inputFilePath = "D:/Jav/src/Topic_5/hw_12/File1.txt";
        String outputFilePath = "D:/Jav/src/Topic_5/hw_12/File2.txt";

        try {
            double product = 1.0;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath)))
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    double number = Double.parseDouble(line);
                    if (number != 0)
                    {
                        product *= Math.abs(number);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)))
            {
                writer.write("Product = " + product);
            }

        }
        catch (IOException e) { e.printStackTrace(); }
    }
}
