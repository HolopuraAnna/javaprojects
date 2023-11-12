package Topic_2;

/**
 * Task_3_2
 * @author Holopura Anna
 */

import java.util.Random;

public class Task_3_2
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] arr = new int[25];
        arr[0] = rand.nextInt(200);
        for (int i = 1; i < 25; i++)
        {
            arr[i] = rand.nextInt(200);
            if (arr[i-1] < arr[i])
            {
                System.out.println(arr[i-1] + " < " + arr[i]);
            }
            else if (arr[i-1] == arr[i])
            {
                System.out.println(arr[i-1] + " = " + arr[i]);
            }
            else
            {
                System.out.println(arr[i-1] + " > " + arr[i]);
            }
        }
    }
}
