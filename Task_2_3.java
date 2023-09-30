/**
 * Task_2_3
 * @author Holopura Anna
 */

 import java.util.Scanner;
 import java.lang.Math;

public class Task_2_3 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Double x = myObj.nextDouble();
        Double y = myObj.nextDouble();
        myObj.close();

        double res = Math.sqrt(x * y);

        System.out.printf("%f\n", res);
        System.out.printf("%e\n", res);
    }
}
