package sof3as3a.harjoitustyo.treenipaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sof3as3a.harjoitustyo.treenipaivakirja.domain.Treeni;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TreeniRepository;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.Tyyppi;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.TyyppiRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TreeniRepositoryTests {
	
	@Autowired
	private TyyppiRepository tyyppiRepo;
	@Autowired
	private TreeniRepository treeniRepo;

	@Test
	void createNewTreeni () {
		Tyyppi tyyppi = new Tyyppi("testi");
		Treeni treeni = new Treeni("testi", "testi", "testi", tyyppi, "testi");
		tyyppiRepo.save(tyyppi);
		treeniRepo.save(treeni);
		assertThat(treeni.getId()).isNotNull();
	}
	
	@Test
	void deleteTreeni () {
		int repositoryLength = (int) treeniRepo.count();
		Tyyppi tyyppi = new Tyyppi("testi");
		Treeni treeni = new Treeni("testi", "testi", "testi", tyyppi, "testi");
		tyyppiRepo.save(tyyppi);
		treeniRepo.save(treeni);
		assertThat(treeni.getId()).isNotNull();
		treeniRepo.delete(treeni);
		assertThat((int) treeniRepo.count()).isEqualTo(repositoryLength);
	}
}
