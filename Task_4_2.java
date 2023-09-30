/**
 * Task_4_2_в
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.lang.Math;

public class Task_4_2
{
    public static double f(double x, double y)
    {
        return x + y + x*x + y*y + Math.pow(x,3) + Math.pow(y,3) + Math.pow(x,4) + Math.pow(y,4);
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        double y = s.nextDouble();
        s.close();

        System.out.println("f(x,y) = " + f(x, y));
    }
}
