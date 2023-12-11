package Topic_5.hw_11;

/**
 * Task_1_4
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_1_4
{
    static public void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replace("an", "").replace("a", "");
        System.out.println(line);
        sc.close();
    }
}
