package Topic_2;

/**
 * Task_3_8
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_3_8
{
    private static final String[] units = {"", "hundred", "thousand", "million"};
    private static final String[] tensNames = {
            "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    private static final String[] numNames = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    public static String subnumber(int n)
    {
        String N = "";
        if (n == 0) return "";

        int a = n % 10;
        int b = (n/10) % 10;
        int c = n/100;

        if (c != 0) N = N + " " + numNames[c] + " " + units[1];

        if (b == 1) return N + " " + numNames[n % 100] + " ";
        else return N + " " + tensNames[b] + " " + numNames[a] + " ";
    }

    public static String number(int n)
    {
        String N = "";
        if (n < 0)
        {
            N = N + "minus";
            n *= -1;
        }
        if (n == 0) return "zero";

        int a = n % 1000;
        int b = (n/1000) % 1000;
        int c = n/1000000;

        if (c != 0 ) N = N + subnumber(c) + units[3];
        if (b != 0 ) N = N + subnumber(b) + units[2];

        return N + subnumber(a);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(number(n));
        sc.close();
    }
}







