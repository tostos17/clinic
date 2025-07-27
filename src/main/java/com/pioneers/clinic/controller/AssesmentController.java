package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.dto.CommentRequest;
import com.pioneers.clinic.participant.model.Player;
import com.pioneers.clinic.participant.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                System.out.println(playerService.updatePlayer(playerById));
                model.addAttribute("message", "success");
                System.out.println("physical assesment updated");
                break;
            case "technical":
                playerById.setTechnicalSkillScore(Integer.parseInt(value));
                System.out.println(playerService.updatePlayer(playerById));
                model.addAttribute("message", "success");
                System.out.println("technical assesment updated");
                break;
            case "tactical":
                playerById.setTacticalSkillScore(Integer.parseInt(value));
                System.out.println(playerService.updatePlayer(playerById));
                model.addAttribute("message", "success");
                System.out.println("tactical assesment updated");
                break;
            case "behavioural":
                playerById.setBehaviouralSkillScore(Integer.parseInt(value));
                System.out.println(playerService.updatePlayer(playerById));
                model.addAttribute("message", "success");
                System.out.println("behavioural assesment updated");
                break;
        }


        return "updatescore";
    }

    @GetMapping("/scores")
    public String getScores(Model model){
        model.addAttribute("scores", playerService.getAllPlayers());

        return "board";
    }

    @GetMapping("/comment")
    public String commentForm(Model model){
        model.addAttribute("participants", playerService.getAllPlayers());

        return "commentpage";
    }

    @PostMapping("/addcomment")
    public String registerComment(@RequestBody CommentRequest comment, Model model) {
        model.addAttribute("message", "failed");

        Player player = new Player();
         try{
             player = playerService.getPlayerById(comment.getPlayerId());
             player.setComment(comment.getComment());
             playerService.updatePlayer(player);
             model.addAttribute("message", "success");
         } catch (Exception e) {
             throw new RuntimeException(e);
         }


         return "commentResponse";
    }

}
