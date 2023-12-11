package Topic_5.hw_11;

/**
 * Task_2_3
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_2_3
{
    public static class Sequence
    {
        char symbol;
        int length;

        public Sequence(char symbol, int length)
        {
            this.symbol = symbol;
            this.length = length;
        }
    }

    public static Sequence findLongestSequence(String line)
    {
        if (line.isEmpty())
        {
            return new Sequence('\0', 0);
        }

        char currentChar = line.charAt(0);
        int currentLength = 1;

        char longestChar = currentChar;
        int longestLength = currentLength;

        for (int i = 1; i < line.length(); i++)
        {
            char nextChar = line.charAt(i);

            if (nextChar == currentChar) { currentLength++; }
            else
            {
                if (currentLength > longestLength)
                {
                    longestChar = currentChar;
                    longestLength = currentLength;
                }

                currentChar = nextChar;
                currentLength = 1;
            }
        }

        if (currentLength > longestLength)
        {
            longestChar = currentChar;
            longestLength = currentLength;
        }

        return new Sequence(longestChar, longestLength);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        Sequence sequence = findLongestSequence(line);
        
        System.out.println(sequence.symbol + " occurs " + sequence.length + " times");
    }
}
