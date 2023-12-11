package Topic_5.hw_11;

/**
 * Task_1_5
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_1_5
{
    static public void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replace("small", "very small").replace("large", "very large");
        System.out.println(str);
        sc.close();
    }
}
