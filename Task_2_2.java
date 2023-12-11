package Topic_5.hw_11;

/**
 * Task_2_2
 * @author Holopura Anna
 */

 import java.util.Scanner;
 import java.math.BigInteger;

public class Task_2_2
{
    public static boolean numbersAndLettersOnly(String line)
    {
        for (char c : line.toCharArray())
        {
            if (!Character.isDigit(c) && !Character.isLetter(c))
            {
                System.out.println("Contains not only numbers and letters");
                return false;
            }
        }
        System.out.println("Contains only numbers and letters");
        return true; 
    }

    public static boolean isMultipleOf9(String input)
    {
        try
        {
            BigInteger number = new BigInteger(input);
            if (number.mod(BigInteger.valueOf(9)).equals(BigInteger.ZERO))
            {
                System.out.println("Is a multiple of 9");
                return true;
            }

            System.out.println("Is not a multiple of 9");
            return false;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Is not a multiple of 9");
            return false;
        }
    }

    public static boolean funcB(String line)
    {
        char firstChar = line.charAt(0);
        if (firstChar == '0' || !Character.isDigit(firstChar))
        {
            System.out.println("Line starts with 0");
            return false;
        }

        int numberOfCharacters = Character.getNumericValue(firstChar);

        if (line.length() != numberOfCharacters + 1)
        {
            System.out.println("Number of letters isn't equal to the first number");
            return false;
        }

        for (int i = 1; i <= numberOfCharacters; i++)
        {
            char currentChar = line.charAt(i);
            if (!Character.isLetter(currentChar))
            {
                System.out.println("Not all of the characters are letters");
                return false;
            }
        }
        System.out.println("Number of letters is equal to the first number");
        return true;
    }

    public static boolean isSumEqualLength(String line)
    {
        int sum = 0;

        for (char c : line.toCharArray())
        {
            if (Character.isDigit(c))
            {
                sum += Character.getNumericValue(c);
            }
        }
        if (sum == line.length())
        {
            System.out.println("Sum of numbers equals to the length of line");
            return true;
        }
        System.out.println("Sum of numbers does not equal to the length of line");
        return false;
    }

    public static boolean isSegment(String line)
    {
        String reference = "0123456789";
        if (reference.contains(line))
        {
            System.out.println("Line is a segment of 0123456789");
            return true;
        }
        System.out.println("Line is not a segment of 0123456789");
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        numbersAndLettersOnly(line);
        isMultipleOf9(line);
        funcB(line);
        isSumEqualLength(line);
        isSegment(line);
    }
}
