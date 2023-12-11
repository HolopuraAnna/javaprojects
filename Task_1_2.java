package Topic_5.hw_11;

/**
 * Task_1_2
 * @author Holopura Anna
 */

public class Task_1_2
{
    private static String reverseText(String text)
    {
        return new StringBuilder(text).reverse().toString();
    }

    public static void main(String[] args)
    {
        String text;

        if (args.length > 0)
        {
            text = String.join(" ", args);
        }
        else
        {
            text = "Example of text to reverse.";
        }

        String reversedText = reverseText(text);
        System.out.println("Reversed text: " + reversedText);
    }
}
