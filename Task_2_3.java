package Topic_3;

/**
 * Task_2_3
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.util.Random;

public class Task_2_3
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

    private static void longestIncreasingSequence(int[][] matrix)
    {
        int longestSequenceLength = 0;
        int[] longestSequence = {};

        for (int[] row : matrix)
        {
            int currentLength = 1;
            int[] currentSequence = {row[0]};
            for (int i = 1; i < row.length; i++)
            {
                if (row[i] > row[i - 1])
                {
                    currentLength++;
                    int[] newSequence = new int[currentLength];
                    System.arraycopy(currentSequence, 0, newSequence, 0, currentLength - 1);
                    newSequence[currentLength - 1] = row[i];
                    currentSequence = newSequence;
                }
                else
                {
                    currentLength = 1;
                    currentSequence = new int[]{row[i]};
                }
            }

            if (currentLength > longestSequenceLength)
            {
                longestSequenceLength = currentLength;
                longestSequence = currentSequence;
            }
        }

        System.out.println("Longest increasing sequence in rows:");

        for (int num : longestSequence)
        {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("number of rows: ");
        int m = sc.nextInt();
        System.out.print("number of columns: ");
        int n = sc.nextInt();

        int[][] matrix = createMatrix(m, n);

        System.out.println("matrix:");
        printMatrix(m, n, matrix);
        
        sc.close();
        longestIncreasingSequence(matrix);
    }
}
