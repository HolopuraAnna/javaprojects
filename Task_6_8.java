package Topic_5.hw_12;

/**
 * Task_6_8
 * @author Holopura Anna
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Task_6_8
{
    public static void main(String[] args)
    {
        String teamsFilePath = "teams.txt";
        String matchesFilePath = "matches.txt";

        createTeamsFile(teamsFilePath);
        createMatchesFile(matchesFilePath);

        addMatchResult(teamsFilePath, matchesFilePath, 1, 2, 3, 2);

        String leader = determineCurrentLeader(teamsFilePath, matchesFilePath);
        System.out.println("The current leader is: " + leader);
    }

    public static void createTeamsFile(String filePath)
    {
        try
        {
            List<String> teams = Arrays.asList("Team1", "Team2", "Team3", "Team4");
            Files.write(Paths.get(filePath), teams, StandardOpenOption.CREATE);
        }
        catch (IOException e)
        {
            System.err.println("Error creating teams file: " + e.getMessage());
        }
    }

    public static void createMatchesFile(String filePath)
    {
        try {
            List<String> matches = Arrays.asList("T_Match 1, 2; 3, 2; T_Match;","T_Match 2, 3; 1, 1; T_Match;","T_Match 3, 4; 2, 4; T_Match;");
            Files.write(Paths.get(filePath), matches, StandardOpenOption.CREATE);
        }
        catch (IOException e)
        {
            System.err.println("Error creating matches file: " + e.getMessage());
        }
    }

    public static void addMatchResult(String teamsFilePath, String matchesFilePath, int team1, int team2, int goals1, int goals2)
    {
        try {
            List<String> matches = Files.readAllLines(Paths.get(matchesFilePath));

            String newMatch = String.format("T_Match %d, %d; %d, %d; T_Match;", team1, team2, goals1, goals2);
            matches.add(newMatch);

            Files.write(Paths.get(matchesFilePath), matches, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("New match result added.");
        }
        catch (IOException e)
        {
            System.err.println("Error adding match result: " + e.getMessage());
        }
    }

    public static Map<String, Integer> calculatePoints(List<String> teams, List<String> matches)
    {
        Map<String, Integer> teamPoints = new HashMap<>();

        for (String match : matches)
        {
            String[] parts = match.split("[,;\\s]+");
            int team1 = Integer.parseInt(parts[1]);
            int team2 = Integer.parseInt(parts[2]);
            int goals1 = Integer.parseInt(parts[4]);
            int goals2 = Integer.parseInt(parts[5]);

            if (goals1 > goals2)
            {
                teamPoints.put(teams.get(team1 - 1), teamPoints.getOrDefault(teams.get(team1 - 1), 0) + 3);
            }
            else if (goals1 < goals2)
            {
                teamPoints.put(teams.get(team2 - 1), teamPoints.getOrDefault(teams.get(team2 - 1), 0) + 3);
            }
            else
            {
                teamPoints.put(teams.get(team1 - 1), teamPoints.getOrDefault(teams.get(team1 - 1), 0) + 1);
                teamPoints.put(teams.get(team2 - 1), teamPoints.getOrDefault(teams.get(team2 - 1), 0) + 1);
            }
        }
        return teamPoints;
    }

    public static int calculateGoalDifference(String team, List<String> teams, List<String> matches)
    {
        int teamIndex = teams.indexOf(team) + 1;
        int goalsScored = 0;
        int goalsConceded = 0;

        for (String match : matches)
        {
            String[] parts = match.split("[,;\\s]+");
            int team1 = Integer.parseInt(parts[1]);
            int team2 = Integer.parseInt(parts[2]);
            int goals1 = Integer.parseInt(parts[4]);
            int goals2 = Integer.parseInt(parts[5]);

            if (team1 == teamIndex)
            {
                goalsScored += goals1;
                goalsConceded += goals2;
            }
            else if (team2 == teamIndex)
            {
                goalsScored += goals2;
                goalsConceded += goals1;
            }
        }

        return goalsScored - goalsConceded;
    }

    public static int calculateGoalsScored(String team, List<String> teams, List<String> matches)
    {
        int teamIndex = teams.indexOf(team) + 1;
        int goals = 0;

        for (String match : matches)
        {
            String[] parts = match.split("[,;\\s]+");
            int team1 = Integer.parseInt(parts[1]);
            int team2 = Integer.parseInt(parts[2]);
            int goals1 = Integer.parseInt(parts[4]);
            int goals2 = Integer.parseInt(parts[5]);

            if (team1 == teamIndex)
            {
                goals += goals1;
            }
            else if (team2 == teamIndex)
            {
                goals += goals2;
            }
        }
        return goals;
    }

    public static String determineCurrentLeader(String teamsFilePath, String matchesFilePath)
    {
        try {
            List<String> teams = Files.readAllLines(Paths.get(teamsFilePath));
            List<String> matches = Files.readAllLines(Paths.get(matchesFilePath));

            Map<String, Integer> teamPoints = calculatePoints(teams, matches);

            int maxPoints = Collections.max(teamPoints.values());
            List<String> leaders = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : teamPoints.entrySet())
            {
                if (entry.getValue() == maxPoints)
                {
                    leaders.add(entry.getKey());
                }
            }

            if (leaders.size() > 1)
            {
                String leadingTeam = determineLeadingTeam(leaders, teams, matches);
                leaders.clear();
                leaders.add(leadingTeam);
            }

            if (leaders.size() > 1)
            {
                Random random = new Random();
                return leaders.get(random.nextInt(leaders.size()));
            }
            return leaders.get(0);
        }
        catch (IOException e)
        {
            System.err.println("Error determining leader: " + e.getMessage());
            return null;
        }
    }

    public static String determineLeadingTeam(List<String> leaders, List<String> teams, List<String> matches)
    {
        String leadingTeam = leaders.get(0);
        int maxGoalDifference = calculateGoalDifference(leadingTeam, teams, matches);
        int maxGoalsScored = calculateGoalsScored(leadingTeam, teams, matches);

        for (String team : leaders)
        {
            int goalDifference = calculateGoalDifference(team, teams, matches);
            int goalsScored = calculateGoalsScored(team, teams, matches);

            if (goalDifference > maxGoalDifference || (goalDifference == maxGoalDifference && goalsScored > maxGoalsScored))
            {
                maxGoalDifference = goalDifference;
                maxGoalsScored = goalsScored;
                leadingTeam = team;
            }
        }

        return leadingTeam;
    }
}
