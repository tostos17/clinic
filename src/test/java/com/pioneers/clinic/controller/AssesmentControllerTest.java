package com.pioneers.clinic.controller;

import com.pioneers.clinic.participant.dto.PlayerDto;
import com.pioneers.clinic.participant.model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AssesmentControllerTest {

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
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/assessment");
    }

    @Test
    public void testPhysicalAssessment() {
        PlayerDto playerDto = new PlayerDto("baba", "bobs", 14);

        String url = "http://localhost:" + port + "/player";

        restTemplate.postForObject(url.concat("/add"), playerDto, String.class);


        ResponseEntity<List<Player>> response = restTemplate.exchange(
                url.concat("/getall"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Player>>() {}
        );

        assertNotNull(response);
        assertNotNull(response.getBody());

        Player player = response.getBody().get(0);
        String updateUrl = "http://localhost:" + port + "/assessment/updatescore?name=" + player.getId() + "&value=5&subject=physical";

        String updateResponse = restTemplate.getForObject(updateUrl, String.class);
        System.out.println(updateResponse);
        assertNotNull(updateResponse);
        assertTrue(updateResponse.contains("success"));

    }

}