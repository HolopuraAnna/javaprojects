package Topic_3;

/**
 * Task_1_10
 * @author Holopura Anna
 */

public class Task_1_10
{
    public static boolean isPalindrome(int n)
    {
        String N = Integer.toString(n);
        return N.equals(new StringBuilder(N).reverse().toString());
    }

    public static void findPalindrome(int[] numbers)
    {
        int palindrome = 0;
        int c = 0;
        for (int n : numbers)
        {
            if (isPalindrome(n))
            {
                if (c == 1)
                {
                    System.out.print(n);
                    return;
                }
                else
                {
                    palindrome = n;
                    c += 1;
                }
            }
        }
        if (c == 0)
        {
            System.out.print("there is no palindrome among the numbers");
            return;
        }
        System.out.print(palindrome);
        return;
    }

    public static void main(String[] args)
    {
        int[] numbers = {123, 121, 789, 4935, 4554, 32, 343};
        findPalindrome(numbers);
    }
}
