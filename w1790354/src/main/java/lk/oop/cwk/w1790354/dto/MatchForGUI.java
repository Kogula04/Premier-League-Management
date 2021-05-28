package lk.oop.cwk.w1790354.dto;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lombok.Data;
import java.text.SimpleDateFormat;

@Data
public class MatchForGUI {
    private String clubA;
    private String clubB;
    private int clubAScore;
    private int clubBScore;
    private String date;

    public MatchForGUI(Match obj) {
        this.clubA = obj.getClubA().getClubName();
        this.clubB = obj.getClubB().getClubName();
        this.clubAScore = obj.getClubAScore();
        this.clubBScore = obj.getClubBScore();
        this.date = new SimpleDateFormat("MM-dd-yyyy").format(obj.getDate());
    }
}
