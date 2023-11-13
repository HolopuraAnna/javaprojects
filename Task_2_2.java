package Topic_3;

/**
 * Task_2_2
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.util.Random;

public class Task_2_2
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
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] shiftLeft(int m, int n, int[][] matrix, int k)
    {
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int newCol = (j - k) % n;
                if (newCol < 0) newCol += n;
                shiftedMatrix[i][newCol] = matrix[i][j];
            }
        }
        return shiftedMatrix;
    }

    private static int[][] shiftRight(int m, int n, int[][] matrix, int k)
    {
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int newCol = (j + k) % n;
                shiftedMatrix[i][newCol] = matrix[i][j];
            }
        }
        return shiftedMatrix;
    }

    private static int[][] shiftUp(int m, int n, int[][] matrix, int k)
    {
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            int newRow = (i - k) % m;
            if (newRow < 0) newRow += m;

            for (int j = 0; j < n; j++)
            {
                shiftedMatrix[newRow][j] = matrix[i][j];
            }
        }
        return shiftedMatrix;
    }

    private static int[][] shiftDown(int m, int n, int[][] matrix, int k)
    {
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            int newRow = (i + k) % m;
            for (int j = 0; j < n; j++)
            {
                shiftedMatrix[newRow][j] = matrix[i][j];
            }
        }
        return shiftedMatrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("number of rows: ");
        int m = sc.nextInt();
        System.out.print("number of columns: ");
        int n = sc.nextInt();
        System.out.print("number of positions to shift: ");
        int k = sc.nextInt();
        sc.close();

        int[][] matrix = createMatrix(m, n);

        System.out.println("initial matrix:");
        printMatrix(m, n, matrix);
        System.out.println();

        int[][] matrixShiftedLeft = shiftLeft(m, n, matrix, k);
        System.out.println("matrix shifted left by " + k + " positions:");
        printMatrix(m, n, matrixShiftedLeft);

        int[][] matrixShiftedRight = shiftRight(m, n, matrix, k);
        System.out.println("matrix shifted right by " + k + " positions:");
        printMatrix(m, n, matrixShiftedRight);

        int[][] matrixShiftedUp = shiftUp(m, n, matrix, k);
        System.out.println("matrix shifted up by " + k + " positions:");
        printMatrix(m, n, matrixShiftedUp);

        int[][] matrixShiftedDown = shiftDown(m, n, matrix, k);
        System.out.println("matrix shifted down by " + k + " positions:");
        printMatrix(m, n, matrixShiftedDown);
    }    
}