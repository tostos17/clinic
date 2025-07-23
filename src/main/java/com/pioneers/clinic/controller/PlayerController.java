package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.dto.PlayerDto;
import com.pioneers.clinic.participant.service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
