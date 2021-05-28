package lk.oop.cwk.w1790354.dto;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class SportsClub implements Serializable {
    private static final long serialVersionUID = 777322596260401818L;

    private String registrationNo;
    private String clubName;
    private String location;
    private String email;

    public SportsClub(String registrationNo, String clubName, String location, String email) {
        this.registrationNo = registrationNo;
        this.clubName = clubName;
        this.location = location;
        this.email = email;
    }

    public SportsClub() {
    }

    public SportsClub(String clubName) {
        this.clubName = clubName;
    }
}
