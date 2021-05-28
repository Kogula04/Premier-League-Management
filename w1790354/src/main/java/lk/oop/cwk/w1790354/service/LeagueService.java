package lk.oop.cwk.w1790354.service;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lk.oop.cwk.w1790354.dto.FootballClub;
import lk.oop.cwk.w1790354.dto.MatchForGUI;

import java.io.IOException;
import java.util.List;

public interface LeagueService {

    List<FootballClub> getClubs() throws IOException, ClassNotFoundException;

    List<MatchForGUI> getMatches() throws IOException, ClassNotFoundException;

    List<MatchForGUI> generateMatch() throws IOException, ClassNotFoundException;
}
