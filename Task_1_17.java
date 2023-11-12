package Topic_3;

/**
 * Task_1_17
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.List;

public class Task_1_17
{
    public static List<List<Integer>> increasingSegments(int n, int[] numbers) {
        List<List<Integer>> segments = new ArrayList<>();
        List<Integer> currentSegment = new ArrayList<>();

        for (int i = 0; i < n-1; i++)
        {
            currentSegment.add(numbers[i]);

            if (numbers[i] >= numbers[i+1])
            {
                if (!currentSegment.isEmpty()) {
                    if (segments.isEmpty() || currentSegment.size() > segments.get(0).size())
                    {
                        segments.clear();
                        segments.add(new ArrayList<>(currentSegment));
                    }
                    else if (currentSegment.size() == segments.get(0).size())
                    {
                        segments.add(new ArrayList<>(currentSegment));
                    }
                    currentSegment.clear();
                }
            }
        }

        if (!currentSegment.isEmpty())
        {
            currentSegment.add(numbers[n-1]);
            if (segments.isEmpty() || currentSegment.size() > segments.get(0).size())
            {
                segments.clear();
                segments.add(new ArrayList<>(currentSegment));
            }
            else if (currentSegment.size() == segments.get(0).size())
            {
                segments.add(new ArrayList<>(currentSegment));
            }
        }

        return segments;
    }

    public static List<List<Integer>> decreasingSegments(int n, int[] numbers)
    {
        List<List<Integer>> segments = new ArrayList<>();
        List<Integer> currentSegment = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            currentSegment.add(numbers[i]);

            if (numbers[i] <= numbers[i+1])
            {
                if (!currentSegment.isEmpty())
                {
                    if (segments.isEmpty() || currentSegment.size() > segments.get(0).size())
                    {
                        segments.clear();
                        segments.add(new ArrayList<>(currentSegment));
                    }
                    else if (currentSegment.size() == segments.get(0).size())
                    {
                        segments.add(new ArrayList<>(currentSegment));
                    }
                    currentSegment.clear();
                }
            }
        }

        if (!currentSegment.isEmpty()) {
            currentSegment.add(numbers[n-1]);
            if (segments.isEmpty() || currentSegment.size() > segments.get(0).size())
            {
                segments.clear();
                segments.add(new ArrayList<>(currentSegment));
            }
            else if (currentSegment.size() == segments.get(0).size())
            {
                segments.add(new ArrayList<>(currentSegment));
            }
        }

        return segments;
    }

    public static List<List<Integer>> longestSegments(int n, int[] numbers)
    {
        List<List<Integer>> increasing_segments = increasingSegments(n, numbers);
        List<List<Integer>> decreasing_segments = decreasingSegments(n, numbers);

        if (increasing_segments.get(0).size() == decreasing_segments.get(0).size())
        {
            increasing_segments.addAll(decreasing_segments);
            return increasing_segments;
        }
        if (increasing_segments.get(0).size() < decreasing_segments.get(0).size())
        {
            return decreasing_segments;
        }
        if (increasing_segments.get(0).size() > decreasing_segments.get(0).size())
        {
            return increasing_segments;
        }

        return increasing_segments;
    }

    public static void main(String[] args)
    {
        int n = 11;
        int[] numbers = {-1, 3, 2, 5, 6, 7, 3, 2, 1, 1, 1};

        List<List<Integer>> longest_segments = longestSegments(n, numbers);

        for (List<Integer> temp : longest_segments)
        {
            System.out.println(temp);
        }
    }
}
