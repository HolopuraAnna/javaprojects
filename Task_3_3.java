package Topic_4.hw_8;

/**
 * Task_3_3
 * @author Holopura Anna
 */

 import java.lang.Math;

class QuadraticEquation 
 {
    int a;
    int b;
    int c;
    double x1;
    double x2;

    public QuadraticEquation(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void findX()
    {
        int D = b*b + 4*a*c;
        x2 = (double) (-b + Math.sqrt(D)) / (2 * a);
        x1 = (double) (-b - Math.sqrt(D)) / (2 * a);
    }

    public void printEquation()
    {
        System.out.printf("%dx + %dy + %d = 0\n", a, b, c);
    }

    public void printX()
    {
        System.out.printf("min_x = %f, max_x = %f\n", x1, x2);
    }
 }

public class Task_3_3
{
    public static void main(String[] args)
    {
        QuadraticEquation[] fractions = {new QuadraticEquation(1, 2, 3), new QuadraticEquation(2, 5, 3), new QuadraticEquation(4, 1, 3)};
        
        for (QuadraticEquation f : fractions)
        {
            f.printEquation();
            f.findX();
            f.printX();
        }
    }

}
