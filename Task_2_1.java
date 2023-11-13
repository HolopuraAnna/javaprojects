package Topic_3;

/**
 * Task_2_1
 * @author Holopura Anna
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Task_2_1
{
    public static ArrayList<ArrayList<Integer>> sort_rows(ArrayList<ArrayList<Integer>> matrix)
    {
        ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>>(matrix);
        for (ArrayList<Integer> row : M)
        {
            Collections.sort(row);
        }
        return M;
    }

    public static ArrayList<ArrayList<Integer>> sort_columns(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>>(matrix);
        for (int i=0; i<m; i++)
        {
            ArrayList<Integer> column = new ArrayList<>();
            
            for (int j = 0; j < n; j++)
            {
                column.add(M.get(j).get(i));
            }

            Collections.sort(column);

            for (int j = 0; j < n; j++)
            {
                M.get(j).set(i, column.get(j));
            }
        }
        return M;
    }

    public static void print_matrix(ArrayList<ArrayList<Integer>> matrix)
    {
        for (ArrayList<Integer> row : matrix)
        {
            System.out.println(row);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("number of rows: ");
        int n = sc.nextInt();
        System.out.print("number of columns: ");
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            System.out.printf("Enter values for row %d: ", i + 1);
        
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                row.add(value);
            }
        
            matrix.add(row);
        }
        sc.close();

        System.out.println("Matrix with sorted rows");
        print_matrix(sort_rows(matrix));

        System.out.println("Matrix with sorted columns");
        print_matrix(sort_columns(matrix, n, m));
    }
}