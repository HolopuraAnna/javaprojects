package Topic_4.hw_8;

/**
 * Task_3_1
 * @author Holopura Anna
 */

 import java.util.Scanner;

class RationalFraction
{
    private int m;
    private int n;

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

public class Task_3_1
{
    public static void main(String[] args)
    {
        int k = 5;
        RationalFraction[] fractions = new RationalFraction[k];

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < k; i++)
        {
            System.out.printf("k%d:", (i+1));
            System.out.print("m = ");
            int m = scanner.nextInt();
            System.out.print("n = ");
            int n = scanner.nextInt();
            fractions[i] = new RationalFraction(m, n);
        }
        scanner.close();

        for(int i = 0; i < k; i++)
        {
            System.out.print(fractions[i].toString() + " ");
        }
        System.out.println();

        for(int i = 0; i < k-1; i++)
        {
            fractions[i].add(fractions[i+1]);
            System.out.print(fractions[i].toString() + " ");
        }
        System.out.print(fractions[k-1].toString());
    }
}