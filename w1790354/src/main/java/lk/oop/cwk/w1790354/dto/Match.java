package lk.oop.cwk.w1790354.dto;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class Match implements Serializable {
    private FootballClub clubA;
    private FootballClub clubB;
    private int clubAScore;
    private int clubBScore;
    private Date date;

    public Match(FootballClub clubA, FootballClub clubB, int clubAScore, int clubBScore, Date date) {
        this.clubA = clubA;
        this.clubB = clubB;
        this.clubAScore = clubAScore;
        this.clubBScore = clubBScore;
        this.date = date;
    }

    public Match() {
    }
}
