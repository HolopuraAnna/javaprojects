package Topic_3;

/**
 * Task_1_3
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Task_1_3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Double> arr = new ArrayList<>();
        Double x;
        int sum = 0;

        for(int i=0; i<n; i++)
        {
            x = sc.nextDouble();
            arr.add(x);
            sum += x;
        }

        double E = (double) sum/n;
        double d = 0;

        for (Double tmp : arr)
        {
            d += (tmp - E) * (tmp - E);
        }
        Double D = d / n;

        System.out.println("mean = " + E);
        System.out.println("deviation = " + D);
        sc.close();
    }    
}
