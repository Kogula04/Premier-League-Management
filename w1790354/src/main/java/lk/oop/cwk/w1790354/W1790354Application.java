package lk.oop.cwk.w1790354;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lk.oop.cwk.w1790354.dto.FootballClub;
import lk.oop.cwk.w1790354.dto.Match;
import lk.oop.cwk.w1790354.dto.SchoolFootballClub;
import lk.oop.cwk.w1790354.dto.UniversityFootballClub;
import lk.oop.cwk.w1790354.service.impl.PremierLeagueManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class W1790354Application {

    private final static PremierLeagueManager manager = new PremierLeagueManager();
    private static int count = 0;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SpringApplication.run(W1790354Application.class, args);
        manager.retrievedData();

        while (true) {
            System.out.println("*****      Premier League menu     *****\n" +
                    "           press 1:  Create new club and add it to league.....\n" +
                    "           press 2:  Delete existing club from league.........\n" +
                    "           press 3:  Display Statistics for club..............\n" +
                    "           press 4:  Display the Premier League Table.........\n" +
                    "           press 5:  Add a Played Match.......................\n" +
                    "           press 6:  Save Data................................\n" +
                    "           press 7:  Exit.....................................\n" +
                    "Enter Input : ");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addClub();
                    break;
                case 2:
                    deleteClub();
                    break;
                case 3:
                    printListOfStatistics();
                    break;
                case 4:
                    manager.displayLeagueTable();
                    break;
                case 5:
                    addPlayedMatch();
                    break;
                case 6:
                    manager.saveData("manager.txt");
                    System.out.println("*  Saved            *");
                    break;
                case 7:
                    System.out.println("*  Exit            *");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!! Please re-enter...");
            }
        }
    }

    private static void addClub() {
        Scanner input = new Scanner(System.in);
        if (count <= 20) {
            System.out.println("Registration No: ");
            String registrationNo = input.nextLine();

            System.out.println("Insert Club Name: ");
            String clubName = input.nextLine();

            System.out.println("Insert Club Location: ");
            String location = input.nextLine();

            System.out.println("Email Address: ");
            String email = input.nextLine();

            System.out.println("Enter the type of Football Club (U- University Football Club/ S- School Football Club) : ");
            String type = input.nextLine();
            FootballClub club = new FootballClub();

            switch (type) {
                case "U":
                case "u":
                    System.out.println("Enter the University name: ");
                    String uniName = input.nextLine();
                    System.out.println("Enter the division: ");
                    int division = input.nextInt();
                    club = new UniversityFootballClub(registrationNo, clubName, location, email, uniName, division);
                    break;

                case "S":
                case "s":
                    System.out.println("Enter the School name: ");
                    String schoolName = input.nextLine();
                    System.out.println("Enter the division: ");
                    division = input.nextInt();
                    club = new SchoolFootballClub(registrationNo, clubName, location, email, schoolName, division);
                    break;

                default:
                    System.out.println("Invalid Input");
            }
            manager.addFootballClub(club);
            count++;
        } else {
            System.out.println("no free slots"); //Club registration is above 20 limits
        }
    }

    private static void deleteClub() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the club name : ");
        String clubName = input.nextLine();
        System.out.println("Do you want Delete this Record y/n ");
        String choice = input.next();
        if (choice.equalsIgnoreCase("y")) {
            boolean result = manager.deleteClub(clubName);
            if (result) {
                count--;
            }
        } else {
            System.out.println("Delete operation is failed.");
        }
    }

    private static void printListOfStatistics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the club name: ");
        String printClubName = sc.nextLine();
        manager.printListOfStatistics(printClubName);
    }

    private static void addPlayedMatch() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date (format MM-DD-YYYY): ");
        String playedDate = sc.nextLine();
        Date date;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(playedDate);
        } catch (ParseException ex) {
            System.out.println("You have to enter date in format MM-DD-YYYY");
            return;
        }

        System.out.println("Enter Club For: ");
        String clubFor = sc.nextLine();
        FootballClub club1 = manager.validateClubForName(clubFor);
        //System.out.println(club1.getClubName());

        System.out.println("Enter Club Against: ");
        String clubAgainst = sc.nextLine();
        FootballClub club2 = manager.validateClubAgainstName(clubAgainst);

        if (club1 == null || club2 == null) {
            System.out.println("No such club in premier league");
            return;
        }

        System.out.println("Enter Club For goals: ");
        String line = sc.nextLine();
        int clubForGoals = -1;
        try {
            clubForGoals = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (clubForGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }

        System.out.println("Enter Club Against goals: ");
        line = sc.nextLine();
        int clubAgainstGoals = -1;
        try {
            clubAgainstGoals = Integer.parseInt(line);
        } catch (Exception e) {
        }
        if (clubAgainstGoals == -1) {
            System.out.println("You have to enter number of goals");
            return;
        }

        Match match = new Match();
        match.setDate(date);
        match.setClubA(club1);
        match.setClubB(club2);
        match.setClubAScore(clubAgainstGoals);
        match.setClubBScore(clubForGoals);
        club1.setNumOfGoalsScored(club1.getNumOfGoalsScored() + clubForGoals);
        club2.setNumOfGoalsScored(club2.getNumOfGoalsScored() + clubAgainstGoals);
        club1.setNumOfGoalsReceived(club1.getNumOfGoalsReceived() + clubAgainstGoals);
        club2.setNumOfGoalsReceived(club2.getNumOfGoalsReceived() + clubForGoals);
        club1.setMatchesPlayed(club1.getMatchesPlayed() + 1);
        club2.setMatchesPlayed(club2.getMatchesPlayed() + 1);

        if (clubForGoals > clubAgainstGoals) {
            club1.setPoints(club1.getPoints() + 3);
            club1.setNumOfWins(club1.getNumOfWins() + 1);
            club2.setNumOfDefeats(club2.getNumOfDefeats() + 1);
        } else if (clubForGoals < clubAgainstGoals) {
            club2.setPoints(club2.getPoints() + 3);
            club2.setNumOfWins(club2.getNumOfWins() + 1);
            club1.setNumOfDefeats(club1.getNumOfDefeats() + 1);
        } else {
            club1.setPoints(club1.getPoints() + 1);
            club2.setPoints(club2.getPoints() + 1);
            club1.setNumOfDraws(club1.getNumOfDraws() + 1);
            club2.setNumOfDraws(club2.getNumOfDraws() + 1);
        }
        manager.addPlayedMatch(match);
    }
}