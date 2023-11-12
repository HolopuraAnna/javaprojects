package Topic_3;

/**
 * Task_1_4
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_1_4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        String[] numbers = line.split(" ");
        int cur = Integer.parseInt(numbers[0]);
        int maxNumb = cur;
        int maxCount = 1;
        int curCount = 1;

        for (int i = 1; i < numbers.length; i++)
        {
            int num = Integer.parseInt(numbers[i]);
            if (num == cur) curCount++;
            else
            {
                if (curCount > maxCount)
                {
                    maxCount = curCount;
                    maxNumb = cur;
                }
                if (curCount == maxCount && cur > maxNumb)
                {
                    maxCount = curCount;
                    maxNumb = cur;
                }
                cur = num;
                curCount = 1;
            }
        }

        if (curCount > maxCount)
        {
            maxCount = curCount;
            maxNumb = cur;
        }

        System.out.println("number " + maxNumb + " occurs " + maxCount + " times");
    }
}
