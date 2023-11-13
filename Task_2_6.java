package Topic_3;

/**
 * Task_2_6
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.util.Random;

public class Task_2_6
{
    private static int[][] createMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = rand.nextInt(201) - 100;
            }
        }
        return matrix;
    }

    private static void printMatrix(int n, int[][] matrix)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int matrixNorm(int n, int[][] matrix)
    {
        int curRowSum = 0;
        for (int i = 0; i < n; i++)
        {
            curRowSum += Math.abs(matrix[0][i]);
        }
        int maxRowSum = curRowSum;
        for (int i = 1; i < n; i++)
        {
            curRowSum = 0;
            for (int j = 0; j < n; j++)
            {
                curRowSum += Math.abs(matrix[i][j]);
            }
            
            if (curRowSum > maxRowSum) maxRowSum = curRowSum;
        }

        return maxRowSum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("square matrix size: ");
        int n = sc.nextInt();
        sc.close();

        int[][] matrix = createMatrix(n);

        System.out.println("matrix:");
        printMatrix(n, matrix);

        System.out.println("norm = " + matrixNorm(n, matrix));
    }
}
