package sof3as3a.harjoitustyo.treenipaivakirja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof3as3a.harjoitustyo.treenipaivakirja.domain.Treeni;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TreeniRepository;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.Tyyppi;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TyyppiRepository;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.User;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.UserRepository;

@SpringBootApplication
public class TreenipaivakirjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreenipaivakirjaApplication.class, args);
	}
	
	
	//CommandLineRunner that adds test data to database
	@Bean
	public CommandLineRunner demo(TreeniRepository trepository, TyyppiRepository tyrepository, UserRepository urepository) {
		return (args) -> {
			
			//Admin user
			User user1 = new User("admin", "$2a$10$CbWb06TJjjxEgpD50lUcc.IKjTDSPey08vVx2gO9wlUGHdL7PdE2a", "ADMIN");
			urepository.save(user1);
			
			//Test data
			Tyyppi ty1 = new Tyyppi("Kuntosali");
			Tyyppi ty2 = new Tyyppi("Juoksu");
			Tyyppi ty3 = new Tyyppi("Jooga");
			
			tyrepository.save(ty1);
			tyrepository.save(ty2);
			tyrepository.save(ty3);
			
			//Test data
			Treeni t1 = new Treeni("Kevyt juoksulenkki", "1 tunti", "14.3.2023", ty2, "3 kilometrin juoksulenkki keskinopeudella.");
			Treeni t2 = new Treeni("Raskas kuntosalitreeni", "2 tuntia", "12.3.2023", ty1, "Rinta- ja ojentajalihasten raskas kuntosalitreeni.");
			Treeni t3 = new Treeni("Aamujooga", "30 min", "13.3.2023", ty3, "30 minuutin aamujooga herätyksen jälkeen.");
			trepository.save(t1);
			trepository.save(t2);
			trepository.save(t3);
		};
	}

}
