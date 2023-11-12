package Topic_3;

/**
 * Task_1_24
 * @author Holopura Anna
 */

 import java.util.Scanner;

public class Task_1_24
{
    public static int findMaxWeight(int[] weights, int n, int w, int cur_i)
    {
        if (cur_i == n || w == 0) return 0;

        if (weights[cur_i] > w) return findMaxWeight(weights, n, w, cur_i + 1);

        int includeCurrent = weights[cur_i] + findMaxWeight(weights, n, w - weights[cur_i], cur_i + 1);
        int excludeCurrent = findMaxWeight(weights, n, w, cur_i + 1);

        return Math.max(includeCurrent, excludeCurrent);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++)
        {
            weights[i] = scanner.nextInt();
        }

        int maxWeight = findMaxWeight(weights, n, w, 0);
        System.out.println(maxWeight);
        scanner.close();
    }
}
