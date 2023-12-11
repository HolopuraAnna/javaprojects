package Topic_5.hw_11;

/**
 * Task_1_1
 * @author Holopura Anna
 */

public class Task_1_1
{
    private static int countWords(String text)
    {
        String[] words = text.split("\\s+");
        return words.length;
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
            text = "Example of text to count the number of words in.";
        }

        int wordCount = countWords(text);
        System.out.println("Number of words in text: " + wordCount);
    }
}
