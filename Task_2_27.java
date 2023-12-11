package Topic_5.hw_11;

/**
 * Task_2_7
 * @author Holopura Anna
 */

import java.util.Scanner;

public class Task_2_27
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first line: ");
        String line1 = sc.nextLine();
        System.out.print("Enter the second line: ");
        String line2 = sc.nextLine();
        sc.close();

        String line = line1.replaceAll(line2, "");

        System.out.println("Result after removing sublines: " + line);
    }
}
