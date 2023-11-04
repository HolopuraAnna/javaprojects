/**
 * Task_2_19
 * @author Holopura Anna
 */

package Topic_2;

import java.util.Random;

public class Task_2_19
{
    public static String sum(String a)
    {
        int s = 0;
        for (int i = 0; i < a.length(); i++)
        {
            s += Character.getNumericValue(a.charAt(i));
        }
        return Integer.toString(s % 2);
    }

    public static String control_bit(String m)
    {
        String a = "";
        for (int i = 0; i < m.length(); i += 8)
        {
            a = a.concat(m.substring(i, i+7));
            a = a.concat(sum(m.substring(i, i+7)));
        }
        return a;
    }

    public static String random_line()
    {
        Random rand = new Random();
        String line = new String();

        for (int i = 0; i < 32; i++)
        {
            int rand_numb = rand.nextInt(2);
            line = line.concat(Integer.toString(rand_numb));
        }

        return line;
    }

    public static String del_control_bit(String a)
    {
        String b = "";

        for (int i = 0; i < a.length(); i += 8)
        {
            if (sum(a.substring(i, i+7)).equals(String.valueOf(a.charAt(i+7))))
            {
                b = b.concat(a.substring(i, i+7));
            }
            else
            {
                return "control bit on "+ String.valueOf(a.length()-i-8) + " bite is incorect";
            }
        }

        return "28-bit number: " + b;
    }

    public static void main(String[] args)
    {
        int n = 694;
        String m = Integer.toBinaryString(n);
        while (m.length() % 8 != 0)
        {
            m = "0" + m;
        }
        //System.out.println(m);
        //System.out.println(control_bit(m));
        System.out.println(n + " -> " + Integer.parseInt(control_bit(m), 2));

        String a = random_line();
        System.out.println("32-bit number: " + a);
        System.out.println(del_control_bit(a));
    }
}
