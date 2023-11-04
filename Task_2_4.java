/**
 * Task_2_4
 * @author Holopura Anna
 */

package Topic_2;

import java.util.Scanner;

public class Task_2_4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        int temp = 1<<m;
        int ans = n ^ temp;
        System.out.println(ans);
    }
}
