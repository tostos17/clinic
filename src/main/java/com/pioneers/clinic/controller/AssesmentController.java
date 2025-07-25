package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.model.Player;
import com.pioneers.clinic.participant.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/assessment")
public class AssesmentController {

    private final PlayerService playerService;

    public AssesmentController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/assess/{subject}")
    public String assess(@PathVariable String subject, Model model) {
        model.addAttribute("subject", subject);
        model.addAttribute("participants", playerService.getAllPlayers());

//        List<Player> players = new ArrayList<>() {{
//            add(new Player(1, "ben", "dave", 12, 0, 0, 0, 0, ""));
//            add(new Player(2, "fola", "max", 12, 0, 0, 0, 0, ""));
//        }};
//
//        model.addAttribute("participants", players);

        return "assessment";
    }

    @GetMapping("/updatescore")
    public String updateScore(@RequestParam String name, @RequestParam String value, @RequestParam String subject, Model model) {

        Player playerById = playerService.getPlayerById(Long.parseLong(name));
        model.addAttribute("message", "failed");

        switch (subject) {
            case "physical" :
                playerById.setPhysicalSkillScore(Integer.parseInt(value));
                playerService.updatePlayer(playerById);
                model.addAttribute("message", "success");
                break;
            case "technical":
                playerById.setTechnicalSkillScore(Integer.parseInt(value));
                playerService.updatePlayer(playerById);
                model.addAttribute("message", "success");
                break;
            case "tactical":
                playerById.setTacticalSkillScore(Integer.parseInt(value));
                playerService.updatePlayer(playerById);
                model.addAttribute("message", "success");
                break;
        }


        return "updatescore";
    }

    @GetMapping("/scores")
    public String getScores(Model model){
        model.addAttribute("scores", playerService.getAllPlayers());

        return "board";
    }

}
