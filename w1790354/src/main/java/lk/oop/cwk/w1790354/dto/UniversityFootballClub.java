package lk.oop.cwk.w1790354.dto;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UniversityFootballClub extends FootballClub {
    private String uniName;
    private int division;

    public UniversityFootballClub(String registrationNo, String clubName, String location, String email, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsScored, int numOfGoalsReceived, int points, int matchesPlayed, String uniName, int division) {
        super(registrationNo, clubName, location, email, numOfWins, numOfDraws, numOfDefeats, numOfGoalsScored, numOfGoalsReceived, points, matchesPlayed);
        this.uniName = uniName;
        this.division = division;
    }

    public UniversityFootballClub(String uniName, int division) {
        this.uniName = uniName;
        this.division = division;

    }

    public UniversityFootballClub() {
    }

    public UniversityFootballClub(String registrationNo, String clubName, String location, String email, String uniName, int division) {
        super(registrationNo, clubName, location, email);
        this.uniName = uniName;
        this.division = division;
    }

}
