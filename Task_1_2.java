/**
 * Task_1_2
 * @author Holopura Anna
 */

package Topic_2;

import java.util.Scanner;

public class Task_1_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line_1 = sc.nextLine();
        String line_2 = sc.nextLine();

        if (line_1.equals(line_2)) System.out.println("lines are equal");
        else System.out.println("lines are not equal");

        sc.close();
    }
}
