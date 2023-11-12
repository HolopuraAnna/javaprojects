package Topic_2;

/**
 * Task_3_5
 * @author Holopura Anna
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task_3_5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++)
        {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[2]);
        sc.close();
    }
}
