package lk.oop.cwk.w1790354.controller;
/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */

import lk.oop.cwk.w1790354.dto.FootballClub;
import lk.oop.cwk.w1790354.dto.MatchForGUI;
import lk.oop.cwk.w1790354.service.LeagueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping("/clubs")
    public List<FootballClub> getClubs() throws IOException, ClassNotFoundException {
        return leagueService.getClubs();
    }

    @GetMapping("/matches")
    public List<MatchForGUI> getMatches() throws IOException, ClassNotFoundException {
        return leagueService.getMatches();
    }

    @GetMapping("/generate")
    public List<MatchForGUI> generateMatch() throws IOException, ClassNotFoundException {
        return leagueService.generateMatch();
    }
}
