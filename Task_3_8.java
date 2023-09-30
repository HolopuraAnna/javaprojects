/**
 * Task_3_8
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.lang.Math;

public class Task_3_8
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        s.close();

        int whole_part = (int)x;
        double fractional_part = x - (double)whole_part;
        int min_int_grater_than_x_1 = (int) Math.ceil(x);
        int max_int_smaller_than_x_1 = (int) Math.floor(x);
        long rounded_x_1 = Math.round(x);

        int min_int_grater_than_x_2 = (int) x + 1;
        if (x == whole_part) min_int_grater_than_x_2 = (int) x;

        int max_int_smaller_than_x_2 = whole_part;

        int rounded_x_2;
        if (x < (double)whole_part + 0.5) rounded_x_2 = whole_part;
        else rounded_x_2 = whole_part+1;

        System.out.println("whole part = " + whole_part);
        System.out.println("fractional part = " + fractional_part);
        System.out.println("min number grater than x = " + min_int_grater_than_x_1 + " = " + min_int_grater_than_x_2);
        System.out.println("max number smaller than x = " + max_int_smaller_than_x_1 + " = " + max_int_smaller_than_x_2);
        System.out.println("Rounded x = " + rounded_x_1 + " = " + rounded_x_2);
    }
}
