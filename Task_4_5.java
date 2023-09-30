/**
 * Task_4_5
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.lang.Math;

public class Task_4_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double x1 = s.nextDouble();
        double y1 = s.nextDouble();
        s.nextLine();

        double x2 = s.nextDouble();
        double y2 = s.nextDouble();
        s.nextLine();

        double x3 = s.nextDouble();
        double y3 = s.nextDouble();
        s.close();

        double a = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        double b = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        double c = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));

        double p = (a+b+c)/2;
        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        System.out.println("S = " + S);
    }
}
