package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.dto.PlayerDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestPlayerRepo testPlayerRepo;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/player");
    }

    @Test
    public void testAddPlayer() {
        PlayerDto playerDto = new PlayerDto("baba", "bobs", 14);

        String s = restTemplate.postForObject(baseUrl.concat("/add"), playerDto, String.class);

        assertNotNull(s);
        assertTrue(s.equals("Saved Successfully"));
    }

    @Test
    public void testRequiredFirstname() {
        PlayerDto playerDto = new PlayerDto("", "bobs", 14);

        String s = restTemplate.postForObject(baseUrl.concat("/add"), playerDto, String.class);


    }

}