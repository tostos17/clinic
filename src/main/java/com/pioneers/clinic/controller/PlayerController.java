package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.dto.PlayerDto;
import com.pioneers.clinic.participant.model.Player;
import com.pioneers.clinic.participant.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/add")
    public String addPlayer(@RequestBody PlayerDto playerDto){
        return playerService.addPlayer(playerDto);
    }

    @GetMapping("/getall")
    public List<Player> addPlayer(){
        return playerService.getAllPlayers();
    }
}
