package lk.oop.cwk.w1790354.dto;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lombok.Data;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.List;

@Data
@Component
public class Manager implements Serializable {
    private static  final long serialVersionUID = 4458564001810445904L;

    private List<FootballClub> clubs;
    private List<Match> matches;

    public Manager(List<FootballClub> clubs, List<Match> matches) {
        this.clubs = clubs;
        this.matches = matches;
    }

    public Manager() {

    }
}
