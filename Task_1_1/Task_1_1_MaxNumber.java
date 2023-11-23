package Topic_4.Task_1_1;

import java.util.Scanner;

public class Task_1_1_MaxNumber
{
    int [] numbers = new int[2];

    public int[] inp()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        numbers[0] = sc.nextInt();
        System.out.print("b = ");
        numbers[1] = sc.nextInt();
        sc.close();

        return numbers;
    }

    public void printMaxNumber()
    {
        numbers = inp();
        if (numbers[0] > numbers[1])
            System.out.println("max(a,b) = " + numbers[0]);
        else
            System.out.println("max(a,b) = " + numbers[1]);
    }
}
