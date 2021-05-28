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
public class SchoolFootballClub extends FootballClub{
    private String schoolName;
    private int division;

    public SchoolFootballClub(String registrationNo, String clubName, String location, String email, String schoolName, int division) {
        super(registrationNo,clubName,location, email);
        this.schoolName = schoolName;
        this.division = division;
    }
}
