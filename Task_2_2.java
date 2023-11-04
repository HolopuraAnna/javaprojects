/**
 * Task_2_2
 * @author Holopura Anna
 */

package Topic_2;

import java.util.Scanner;

public class Task_2_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a <<= 1;
        while (a > 0)
        {
            a >>= 1;
            System.out.println(Integer.toBinaryString(a));
        }
        sc.close();
    }
}
