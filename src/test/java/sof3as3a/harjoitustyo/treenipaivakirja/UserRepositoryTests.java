package sof3as3a.harjoitustyo.treenipaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sof3as3a.harjoitustyo.treenipaivakirja.domain.User;
import sof3as3a.harjoitustyo.treenipaivakirja.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTests {
	
	@Autowired
	private UserRepository repository;

	@Test
	public void createNewUser () {
		User user = new User("testi", "testi", "testi");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
}
