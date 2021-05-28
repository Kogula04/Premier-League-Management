package lk.oop.cwk.w1790354.dto;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import java.util.Comparator;

public class ClubComparator implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {

        if(club1.getPoints() > club2.getPoints())
            return -1;
        else if (club1.getPoints() < club2.getPoints())
            return 1;
        else {
            int goalDif = club1.getNumOfGoalsScored()-club1.getNumOfGoalsReceived();
            int goalDif1 = club2.getNumOfGoalsScored()-club2.getNumOfGoalsReceived();
            return Integer.compare(goalDif1, goalDif);
        }

    }
}