package Topic_2;

/**
 * Task_4_10
 * @author Holopura Anna
 */

import java.util.ArrayList;

public class Task_4_10
{
    public static boolean isPrime(int number)
    {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static ArrayList<Integer> findPrimeNumbers(int a, int b)
    {
        ArrayList<Integer> N = new ArrayList<>();;
        for (int i = a; i <= b; i++)
        {
            if (isPrime(i)) N.add(i);
        }
        return N;
    }

    public static void main(String[] args)
    {
        int a = 7;
        int b = 29;
        System.out.print(findPrimeNumbers(a, b));
    }
}
