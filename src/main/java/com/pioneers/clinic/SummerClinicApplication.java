package com.pioneers.clinic;

import com.pioneers.clinic.participant.dto.PlayerDto;
import com.pioneers.clinic.participant.repository.PlayerRepository;
import com.pioneers.clinic.participant.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SummerClinicApplication {

	@Autowired
	private PlayerService playerService;

	public static void main(String[] args) {
		SpringApplication.run(SummerClinicApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return arg -> {
//			playerService.addPlayer(new PlayerDto("Orooluwa", "Oluwatoyin", 11));
//			playerService.addPlayer(new PlayerDto("Akinmolayan", "Solomon", 14));
//			playerService.addPlayer(new PlayerDto("Bello", "David", 13));
//			playerService.addPlayer(new PlayerDto("Daniel", "Ozah", 8));
//			playerService.addPlayer(new PlayerDto("Yusuf", "Aliameen", 12));
//			playerService.addPlayer(new PlayerDto("Oluwadamilola", "Owolabi", 14));
//			playerService.addPlayer(new PlayerDto("Michael", "Egor", 13));
//			playerService.addPlayer(new PlayerDto("Tometi", "Oluwasemilore", 13));
//			playerService.addPlayer(new PlayerDto("Adeem", "Adenaya", 11));
//			playerService.addPlayer(new PlayerDto("Oreoluwa", "Adegbola", 12));
//			playerService.addPlayer(new PlayerDto("Chikanyima", "Benjamin", 13));
//			playerService.addPlayer(new PlayerDto("Deji", "Famuyibo", 13));
//			playerService.addPlayer(new PlayerDto("Oniha", "Mubarak", 14));
//			playerService.addPlayer(new PlayerDto("Ogben", "Praise", 13));
//			playerService.addPlayer(new PlayerDto("Ogben", "Shekinnah", 10));
//			playerService.addPlayer(new PlayerDto("Udochukwu", "Hope", 11));
//			playerService.addPlayer(new PlayerDto("Okeke", "William", 14));
//			playerService.addPlayer(new PlayerDto("Bakare", "Adeogo", 13));
//			playerService.addPlayer(new PlayerDto("Babalogbon Oluwadarasimi", "Emmanuel", 11));
//		};
//	}

}





