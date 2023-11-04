/**
 * Task_2_3
 * @author Holopura Anna
 */

package Topic_2;

public class Task_2_3
{
    public static String char_to_bin(char a)
    {
        int b = Character.getNumericValue(a);
        String rez = Integer.toBinaryString(b);
        return rez;
    }

    public static void main(String[] args)
    {
        System.out.println(char_to_bin('a'));
        System.out.println(char_to_bin('F'));
        System.out.println(char_to_bin('5'));
    }
}
