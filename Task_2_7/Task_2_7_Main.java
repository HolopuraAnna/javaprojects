package Topic_4.Task_2_7;

/**
 * Task_2_7
 * @author Holopura Anna
 */

import java.util.Arrays;
import java.util.Comparator;

public class Task_2_7_Main
{
    public static void excessShortDistanceCalls(Phone[] phones, Integer limit)
    {
        System.out.println("a)");

        for (Phone p: phones)
        {
            if(p.getShortDistanceCall() > limit)
            {
                p.printPhone();
            }
        }
    }

    public static void longDistanceCalls(Phone[] phones)
    {
        System.out.println("b)");

        for (Phone p: phones)
        {
            if(p.getLongDistanceCall() != 0)
            {
                p.printPhone();
            }
        }
    }

    public static void sortBySurname(Phone[] phones)
    {
        Arrays.sort(phones, Comparator.comparing(Phone::getSurname));

        System.out.println("c)");

        for (Phone p: phones)
        {
            p.printPhone();
        }
    }

    public static void main(String[] args)
    {
        Phone[] phones = {new Phone(64725, "Smitt", "James", "London", "6537892364537112", 563, 324),
                          new Phone(25734, "Black", "Artur", "London", "3492054712537538", 27, 0),
                          new Phone(12345, "Doe", "John", "New York", "9876543210123456", 32, 50),
                          new Phone(67890, "White", "Emma", "Los Angeles", "1111222233334444", 200, 0),
                          new Phone(54321, "Brown", "Michael", "Chicago", "5555666677778888", 150, 25)};
    
        excessShortDistanceCalls(phones, 160);
        System.out.println("\n");

        longDistanceCalls(phones);
        System.out.println("\n");

        sortBySurname(phones);
    }
}
