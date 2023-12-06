package Topic_4.hw_8;

/**
 * Task_4_1
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.List;

class RationalFraction
{
    int m;
    int n;

    public RationalFraction(int m, int n)
    {
        this.m = m;
        this.n = n;
    }

    public void add(RationalFraction other)
    {
        int b = this.n * other.n;
        int a = this.m * other.n + other.m * this.n;
        this.m = a;
        this.n = b;
    }

    public String toString()
    {
        return m + "/" + n;
    }
}

class Polynom
{
    List<RationalFraction> coefficients;

    public Polynom() { coefficients = new ArrayList<>(); }

    public void addCoefficient(RationalFraction coefficient)
    {
        coefficients.add(coefficient);
    }

    public RationalFraction evaluate(int x)
    {
        RationalFraction result = new RationalFraction(0, 1);

        for (int i = 0; i < coefficients.size(); i++)
        {
            RationalFraction term = coefficients.get(i);
            RationalFraction xTerm = new RationalFraction((int) Math.pow(x, i), 1);
            term.add(xTerm);
            result.add(term);
        }

        return result;
    }
}

public class Task_4_1
{
    public static void main(String[] args)
    {
        List<Polynom> polynoms = new ArrayList<>();

        Polynom poly1 = new Polynom();
        poly1.addCoefficient(new RationalFraction(1, 2));
        poly1.addCoefficient(new RationalFraction(3, 4));
        poly1.addCoefficient(new RationalFraction(1, 3));
        polynoms.add(poly1);

        Polynom poly2 = new Polynom();
        poly2.addCoefficient(new RationalFraction(2, 1));
        poly2.addCoefficient(new RationalFraction(1, 2));
        polynoms.add(poly2);

        Polynom poly3 = new Polynom();
        poly3.addCoefficient(new RationalFraction(3, 5));
        poly3.addCoefficient(new RationalFraction(2, 3));
        poly3.addCoefficient(new RationalFraction(5, 6));
        polynoms.add(poly3);

        Polynom sum = new Polynom();
        for (Polynom p: polynoms) {
            for (int i = 0; i < p.coefficients.size(); i++)
            {
                if (i >= sum.coefficients.size())
                {
                    sum.coefficients.add(new RationalFraction(0, 1));
                }
                sum.coefficients.get(i).add(p.coefficients.get(i));
            }
        }

        System.out.println("Sum of Polynoms:");
        for (int i = 0; i < sum.coefficients.size(); i++)
        {
            System.out.println("Coefficient " + i + ": " + sum.coefficients.get(i));
        }
    }
}
