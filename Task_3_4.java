package Topic_2;

/**
 * Task_3_4
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_3_4
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        int a = myObj.nextInt();
        int b = myObj.nextInt();
        int c = myObj.nextInt();
        myObj.close();

        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        String d = Integer.toString(a) + Integer.toString(b) + Integer.toString(c);

        for (int i = 0; i < d.length(); i++)
        {
            if (d.charAt(i) == '1') count_1++;
            if (d.charAt(i) == '2') count_2++;
            if (d.charAt(i) == '3') count_3++;
        }

        System.out.println("1: " + count_1);
        System.out.println("2: " + count_2);
        System.out.println("3: " + count_3);
    }
}
