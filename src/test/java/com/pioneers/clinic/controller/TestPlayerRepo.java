package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPlayerRepo extends JpaRepository<Player, Long> {
}
