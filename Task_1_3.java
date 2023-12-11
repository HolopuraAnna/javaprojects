package Topic_5.hw_11;

/**
 * Task_1_3
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_1_3
{
    static public void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replace("small", "very large");
        System.out.println(str);
        sc.close();
    }
}
