package Topic_2;

/**
 * Task_2_2
 * @author Holopura Anna
 */

import java.util.Random;

public class Task_3_6
{
    public static int exp()
    {
        int Alice = 0;
        int Bob = 0;
        int prev = -1;
        int cur = -1;

        Random rand = new Random();

        do {
            prev = cur;
            cur = rand.nextInt(2);
            Alice++;
        } while (prev != 0 || cur != 0);

        cur = -1;
        do {
            prev = cur;
            cur = rand.nextInt(2);
            Bob++;
        } while (prev != 0 || cur != 1);

         return ((Alice < Bob) ? 1 : 0);
    }

    public static void main(String args[])
    {
        final int N = 1000;
        int count = 0;
        for (int i = 0; i < N; i++) count += exp();

        System.out.println((float) count/N);
    }
}