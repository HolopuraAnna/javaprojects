package Topic_2;

/**
 * Task_4_2
 * @author Holopura Anna
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Task_4_2
{
    public static void main(String args[])
    {
        LocalDate date = LocalDate.of(1999, 8, 13);
        date = date.plusDays(1);

        int count = 0;
        List<Integer> prev = new ArrayList<Integer>();
        for (int i = 0; i < 146097; i++)
        {
            String s = date.getDayOfWeek().toString();
            int d = date.getDayOfMonth();

            if (s == "FRIDAY" & d == 13)
            {
                prev.add(count);
                count = 0;
            }
            count += 1;
            date = date.plusDays(1);
        }
        Collections.sort(prev);
        Collections.reverse(prev);
        System.out.println(prev.get(0) - 1);
    }
}
