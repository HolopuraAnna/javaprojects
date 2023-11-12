package Topic_3;

/**
 * Task_1_2
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_1_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int min = a;
        int max = a;

        do{
            a = sc.nextInt();
            if (a == 0) break;
            if (a < min) min = a;
            if (a > max) max = a;
        }while(true);

        System.out.printf("min = %d\nmax = %d", min, max);
        sc.close();
    }
}
