package lk.oop.cwk.w1790354.service.impl;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lk.oop.cwk.w1790354.dto.FootballClub;
import lk.oop.cwk.w1790354.dto.Manager;
import lk.oop.cwk.w1790354.dto.MatchForGUI;
import lk.oop.cwk.w1790354.service.LeagueManager;
import lk.oop.cwk.w1790354.service.LeagueService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueManager leagueManager;

    public LeagueServiceImpl(LeagueManager leagueManager) {
        this.leagueManager = leagueManager;
    }


    @Override
    public List<FootballClub> getClubs() throws IOException, ClassNotFoundException {
        Manager manager = leagueManager.retrievedData();
        return manager.getClubs();
    }

    @Override
    public List<MatchForGUI> getMatches() throws IOException, ClassNotFoundException {
        Manager manager = leagueManager.retrievedData();
        return getMatchesForGUI(manager);
    }

    @Override
    public List<MatchForGUI> generateMatch() throws IOException, ClassNotFoundException {
        leagueManager.addRandomMatch();
        return getMatchesForGUI(leagueManager.retrievedData());
    }

    private List<MatchForGUI> getMatchesForGUI(Manager manager){
        return manager.getMatches().stream().map(match -> new MatchForGUI(match)).collect(Collectors.toList());
    }
}
