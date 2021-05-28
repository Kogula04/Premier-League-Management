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
public class FootballClub extends SportsClub {
    private static  final long serialVersionUID = 4458564001810445906L;

    private int numOfWins;
    private int numOfDraws;
    private int numOfDefeats;
    private int numOfGoalsScored;
    private int numOfGoalsReceived;
    private int points;
    private int matchesPlayed;

    public FootballClub(String registrationNo, String clubName, String location, String email, int numOfWins, int numOfDraws, int numOfDefeats, int numOfGoalsScored, int numOfGoalsReceived, int points, int matchesPlayed) {
        super(registrationNo, clubName, location, email);
        this.numOfWins = numOfWins;
        this.numOfDraws = numOfDraws;
        this.numOfDefeats = numOfDefeats;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.points = points;
        this.matchesPlayed = matchesPlayed;
    }

    public FootballClub(String registrationNo, String clubName, String location, String email) {
        super(registrationNo,clubName,location,email);
    }

    public FootballClub(){
    }
    public FootballClub(String clubName, int numOfWins, int numOfDefeats, int numOfDraws, int numOfGoalsScored, int numOfGoalsReceived, int points, int matchesPlayed ){
        super(clubName);
        this.numOfWins = numOfWins;
        this.numOfDefeats = numOfDefeats;
        this.numOfDraws = numOfDraws;
        this.numOfGoalsScored= numOfGoalsScored;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.points = points;
        this.matchesPlayed = matchesPlayed;
    }
}