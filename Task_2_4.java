package Topic_3;

/**
 * Task_2_4
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.util.Random;

public class Task_2_4
{
    private static int[][] createMatrix(int m, int n)
    {
        int[][] matrix = new int[m][n];
        Random rand = new Random();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = rand.nextInt(201) - 100;
            }
        }
        return matrix;
    }

    private static void printMatrix(int m, int n, int[][] matrix)
    {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void sumBetweenPositiveElements(int[][] matrix)
    {
        int r = -1;
        for (int[] row : matrix)
        {
            r += 1;
            int firstPositiveIndex = -1;
            int secondPositiveIndex = -1;
            int sum = 0;

            for (int i = 0; i < row.length; i++)
            {
                if (row[i] > 0)
                {
                    if (firstPositiveIndex == -1) firstPositiveIndex = i;
                    else if (secondPositiveIndex == -1)
                    {
                        secondPositiveIndex = i;
                        break;
                    }
                }
            }

            if (firstPositiveIndex != -1 && secondPositiveIndex != -1)
            {
                for (int i = firstPositiveIndex + 1; i < secondPositiveIndex; i++) sum += row[i];

                System.out.println("row[" + r + "]: " + sum);
            }
            else System.out.println("no positive elements found in " + r + " row");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("number of rows: ");
        int m = sc.nextInt();
        System.out.print("number of columns: ");
        int n = sc.nextInt();
        sc.close();

        int[][] matrix = createMatrix(m, n);

        System.out.println("matrix:");
        printMatrix(m, n, matrix);

        sumBetweenPositiveElements(matrix);
    }
}
