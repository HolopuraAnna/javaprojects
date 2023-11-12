package Topic_3;

/**
 * Task_1_1
 * @author Holopura Anna
 */

public class Task_1_1
{
    public static void main(String[] args)
    {
        String[] arr = {"a", "b", "c"};
        for (String s : arr)
        {
            System.out.print(s + ", ");
        }
        System.out.println();
        for (int i=0; i<arr.length; i++)
        {
            System.out.printf("arr[%d] = %s\n", i, arr[i]);
        }
    }
}
