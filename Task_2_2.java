/**
 * Task_2_2
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.lang.Math;

public class Task_2_2 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int x = myObj.nextInt();
        int y = myObj.nextInt();
        myObj.close();

        int x1 = String.valueOf(x).length();
        int y1 = ((int)Math.log10((double)y)) + 1;

        System.out.println(x1);
        System.out.println(y1);

        double res = 2/(1/(double)x + 1/(double)y);
        System.out.printf("%.2f", res);
    }
}
