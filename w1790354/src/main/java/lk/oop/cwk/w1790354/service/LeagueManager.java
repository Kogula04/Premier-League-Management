package lk.oop.cwk.w1790354.service;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lk.oop.cwk.w1790354.dto.FootballClub;
import lk.oop.cwk.w1790354.dto.Manager;
import lk.oop.cwk.w1790354.dto.Match;

import java.io.IOException;

public interface LeagueManager {
    void addFootballClub(FootballClub club);
    boolean deleteClub(String clubName);
    void printListOfStatistics(String printClubName);
    void displayLeagueTable();
    FootballClub validateClubForName(String clubFor);
    FootballClub validateClubAgainstName(String clubAgainst);
    void addPlayedMatch(Match match);
    void saveData(String fileName) throws IOException;
    Manager retrievedData() throws IOException, ClassNotFoundException;

    void addRandomMatch() throws IOException;
}
