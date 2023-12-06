package Topic_4.hw_8;

/**
 * Task_4_3
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.List;

class ComplexNumber
{
    int a;
    int b;

    public ComplexNumber(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void add(ComplexNumber other)
    {
        this.a = this.a + other.a;
        this.b = this.b + other.b;
    }

    public String toString()
    {
        return a + " + " + b + "i";
    }
}

class Polynom
{
    List<ComplexNumber> coefficients;

    public Polynom() { coefficients = new ArrayList<>(); }

    public void addCoefficient(ComplexNumber coefficient)
    {
        coefficients.add(coefficient);
    }

    public ComplexNumber evaluate(int x)
    {
        ComplexNumber result = new ComplexNumber(0, 1);

        for (int i = 0; i < coefficients.size(); i++)
        {
            ComplexNumber term = coefficients.get(i);
            ComplexNumber xTerm = new ComplexNumber((int) Math.pow(x, i), 1);
            term.add(xTerm);
            result.add(term);
        }

        return result;
    }
}

public class Task_4_3
{
    public static void main(String[] args)
    {
        List<Polynom> polynoms = new ArrayList<>();

        Polynom poly1 = new Polynom();
        poly1.addCoefficient(new ComplexNumber(1, 2));
        poly1.addCoefficient(new ComplexNumber(3, 4));
        poly1.addCoefficient(new ComplexNumber(1, 3));
        polynoms.add(poly1);

        Polynom poly2 = new Polynom();
        poly2.addCoefficient(new ComplexNumber(2, 1));
        poly2.addCoefficient(new ComplexNumber(1, 2));
        polynoms.add(poly2);

        Polynom poly3 = new Polynom();
        poly3.addCoefficient(new ComplexNumber(3, 5));
        poly3.addCoefficient(new ComplexNumber(2, 3));
        poly3.addCoefficient(new ComplexNumber(5, 6));
        polynoms.add(poly3);

        Polynom sum = new Polynom();
        for (Polynom p: polynoms) {
            for (int i = 0; i < p.coefficients.size(); i++)
            {
                if (i >= sum.coefficients.size())
                {
                    sum.coefficients.add(new ComplexNumber(0, 1));
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
