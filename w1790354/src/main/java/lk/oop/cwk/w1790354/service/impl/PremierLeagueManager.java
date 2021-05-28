package lk.oop.cwk.w1790354.service.impl;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lk.oop.cwk.w1790354.dto.*;
import lk.oop.cwk.w1790354.service.LeagueManager;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class PremierLeagueManager implements LeagueManager {
    private List<FootballClub> clubList = new ArrayList<FootballClub>();   //which is the I am coming to add the football club,delete club, sort, print, etc.
    private List<Match> matches = new ArrayList<Match>();
    private Manager manager = new Manager();

    @Override
    public void addFootballClub(FootballClub club) {
        if (clubList.size() <= 20) {
            Optional<FootballClub> clubExistOpt = clubList.stream().filter(footballClub -> {
                return footballClub.getClubName().equals(club.getClubName());
            }).findFirst();
            if (!clubExistOpt.isPresent()) {
                clubList.add(club);
                System.out.println(club.getClubName()+" is successfully added to the primer league.");
            } else {
                System.out.println("There is a club with same name.");
            }
        } else {
            System.out.println("No free slots are available for new club registration.");
        }
    }

    @Override
    public boolean deleteClub(String clubName) {
        boolean flag = false;
        for (FootballClub club : clubList) {
            if (club.getClubName().equals(clubName)) {
                flag = true;
                clubList.remove(club);
                System.out.println("Football Club with the club name: " + clubName + " successfully removed.");
                System.out.println("No of occupied slots : " + clubList.size());
                System.out.println("No of free slots : " + (20 - clubList.size()));
                if (club instanceof UniversityFootballClub) {  //what type of has been deleted
                    System.out.println("Football Club type is: UniversityFootballClub");
                } else {
                    System.out.println("Football Club type is: SchoolFootballClub");
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("Football Club with the club name: " + clubName + " is not found.");
        }
        return flag;
    }

    @Override
    public void printListOfStatistics(String printClubName) {
        for (FootballClub club : clubList) {
            if (club.getClubName().equals(printClubName)) {
                System.out.println("Club " + club.getClubName() + " matches won: " + club.getNumOfWins());
                System.out.println("Club " + club.getClubName() + " matches lost: " + club.getNumOfDefeats());
                System.out.println("Club " + club.getClubName() + " matches draw: " + club.getNumOfDraws());
                System.out.println("Club " + club.getClubName() + " scored goals: " + club.getNumOfGoalsScored());
                System.out.println("Club " + club.getClubName() + " received goals: " + club.getNumOfGoalsReceived());
                System.out.println("Club " + club.getClubName() + " points: " + club.getPoints());
                System.out.println("Club " + club.getClubName() + " matches played: " + club.getMatchesPlayed());
                return;
            }
        }
        System.out.println("No such club in premier league");
    }

    @Override
    public void displayLeagueTable() {
        clubList.sort(new ClubComparator());
        for (FootballClub club : clubList) {
            System.out.println("Club: " + club.getClubName() + " Points: " + club.getPoints() + " goal difference: " + (club.getNumOfGoalsScored() - club.getNumOfGoalsReceived()));
        }
    }

    @Override
    public FootballClub validateClubForName(String clubFor) {
        FootballClub club1 = null;
        try {
            for (FootballClub club : clubList) {
                if ((club.getClubName().equals(clubFor))) {
                    club1 = club;
                    return club1;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club1;
    }

    @Override
    public FootballClub validateClubAgainstName(String clubAgainst) {
        FootballClub club2 = null;
        try {
            for (FootballClub club : clubList) {
                if ((club.getClubName().equals(clubAgainst))) {
                    club2 = club;
                    return club2;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return club2;
    }

    @Override
    public void addPlayedMatch(Match match) {
        matches.add(match);
    }

    public void saveData(String fileName) throws IOException {
        fileName = "manager.txt";
        try {
            if (clubList.isEmpty()) {
                System.out.println("Premier League does not have any data to save.");
                return;
            }

            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            manager.setClubs(clubList);
            manager.setMatches(matches);
            oos.writeObject(manager);

            oos.flush();
            fos.close();
            oos.close();
            System.out.println("Data has been successfully saved to the file.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Manager retrievedData() throws IOException, ClassNotFoundException {
        String fileName = "manager.txt";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (; ; ) {
                try {
                    manager = (Manager) ois.readObject();
                    clubList = manager.getClubs();
                    matches = manager.getMatches();
                } catch (EOFException e) {
                    break;
                }
            }

            fis.close();
            ois.close();
            //System.out.println("Club date : "+ matches.get(0).getDate());
            System.out.println("Data has been successfully loaded from the file.");

        } catch (FileNotFoundException e) {
        }
        return manager;
    }

    @Override
    public void addRandomMatch() throws IOException {
        Random random = new Random();
        FootballClub clubFor = clubList.get(random.nextInt(clubList.size()));
        clubList.remove(clubFor);
        FootballClub clubAgainst = clubList.get(random.nextInt(clubList.size()));
        int clubForGoals = random.nextInt(10);
        int clubAgainstGoals = random.nextInt(10);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, random.nextInt(10));
        Date date= calendar.getTime();

        Match match = new Match();
        match.setDate(date);
        match.setClubA(clubFor);
        match.setClubB(clubAgainst);
        match.setClubAScore(clubForGoals); //
        match.setClubBScore(clubAgainstGoals);  //
        clubFor.setNumOfGoalsScored(clubFor.getNumOfGoalsScored() + clubForGoals);
        clubAgainst.setNumOfGoalsScored(clubAgainst.getNumOfGoalsScored() + clubAgainstGoals);
        clubFor.setNumOfGoalsReceived(clubFor.getNumOfGoalsReceived() + clubAgainstGoals);  //
        clubAgainst.setNumOfGoalsReceived(clubAgainst.getNumOfGoalsReceived() + clubForGoals);   //
        clubFor.setMatchesPlayed(clubFor.getMatchesPlayed() + 1);
        clubAgainst.setMatchesPlayed(clubAgainst.getMatchesPlayed() + 1);

        if (clubForGoals > clubAgainstGoals) {
            clubFor.setPoints(clubFor.getPoints() + 3);
            clubFor.setNumOfWins(clubFor.getNumOfWins() + 1);
            clubAgainst.setNumOfDefeats(clubAgainst.getNumOfDefeats() + 1);
        } else if (clubForGoals < clubAgainstGoals) {
            clubAgainst.setPoints(clubAgainst.getPoints() + 3);
            clubAgainst.setNumOfWins(clubAgainst.getNumOfWins() + 1);
            clubFor.setNumOfDefeats(clubFor.getNumOfDefeats() + 1);
        } else {
            clubFor.setPoints(clubFor.getPoints() + 1);
            clubAgainst.setPoints(clubAgainst.getPoints() + 1);
            clubFor.setNumOfDraws(clubFor.getNumOfDraws() + 1);
            clubAgainst.setNumOfDraws(clubAgainst.getNumOfDraws() + 1);
        }
        this.addPlayedMatch(match);
        this.replaceClub(clubFor);
        this.replaceClub(clubAgainst);
        this.saveData("manager.txt");
    }

    private void replaceClub(FootballClub club) {
        AtomicBoolean clubExists = new AtomicBoolean(false);
        clubList = clubList.stream().map(footballClub -> {
            if(footballClub.getClubName().equals(club.getClubName())){
                clubExists.set(true);
                return club;
            }
            return footballClub;
        }).collect(Collectors.toList());
        if(!clubExists.get()){
            clubList.add(club);
        }
    }
}