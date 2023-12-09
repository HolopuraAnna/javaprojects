package Topic_4.hw_10;

public class QuadraticEquation
{
    public static void main(String args[])
    {
        float a = 5.8f;
        float b = 12.6f;
        float c = 3.72f;

        try {
            if (a == 0)
                throw new ArithmeticException("a coefficient can't be zero!!!");

            double D = Math.pow(b, 2) - 4 * a * c;

            if (D < 0)
                throw new SqrnExeption("D is negative, no real roots!!!");

            double D_sqrt = Math.sqrt(D);
            double x1 = (-b + D_sqrt) / 2 * a;
            double x2 = (-b - D_sqrt) / 2 * a;

            System.out.println("Roots: x1=" + x1 + " x2=" + x2);

        }
        catch (SqrnExeption e) { System.out.println(e.toString()); }
        catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
