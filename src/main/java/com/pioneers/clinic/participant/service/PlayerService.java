package com.pioneers.clinic.participant.service;

import com.pioneers.clinic.participant.dto.PlayerDto;
import com.pioneers.clinic.participant.model.Player;
import com.pioneers.clinic.participant.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public String addPlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setFirstname(playerDto.getFirstname());
        player.setLastname(playerDto.getLastname());
        player.setAge(playerDto.getAge());

        Player saved = new Player();

        try {
            saved = playerRepository.save(player);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return saved.getId() > 0 ? "Saved Successfully" : "Save Operation Failed";
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

}
