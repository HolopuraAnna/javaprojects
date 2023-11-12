package Topic_2;

/**
 * Task_4_1
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_4_1
{
    public static void DecimalExpansion(int p, int q)
    {
        float c = (float) p / q;
        String [] s = Float.toString(c).split("\\.");
        System.out.println("origin => " + s[0] + "." + s[1]);
        String input = s[1];

        String first_ch = Character.toString(input.charAt(0));
        List<String> list = new ArrayList<String>();
        list.add(first_ch);

        for (int i = 1; i < input.length(); i++)
        {
            if (!Character.toString(input.charAt(i)).equals(first_ch))
            {
                list.add(Character.toString(input.charAt(i)));
            }
            else break;
        }

        String result = ".(";
        for (int i = 0; i < list.size(); i++)
        {
            result += list.get(i);
        }
        result += ")";

        System.out.println("result => " + s[0] + result);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        DecimalExpansion(p, q);
        sc.close();
    }        
}
