package sof3as3a.harjoitustyo.treenipaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sof3as3a.harjoitustyo.treenipaivakirja.domain.Tyyppi;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TyyppiRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TyyppiRepositoryTests {
	
	@Autowired
	private TyyppiRepository tyyppiRepo;

	@Test
	void createNewTyyppi () {
		Tyyppi tyyppi = new Tyyppi("testi");
		tyyppiRepo.save(tyyppi);
		assertThat(tyyppi.getNimi()).isNotNull();
	}
	
	@Test
	void deleteTyyppi () {
		int repositoryLength = (int) tyyppiRepo.count();
		Tyyppi tyyppi = new Tyyppi("testi");
		tyyppiRepo.save(tyyppi);
		assertThat(tyyppi.getNimi()).isNotNull();
		tyyppiRepo.delete(tyyppi);
		assertThat((int) tyyppiRepo.count()).isEqualTo(repositoryLength);
	}
}
