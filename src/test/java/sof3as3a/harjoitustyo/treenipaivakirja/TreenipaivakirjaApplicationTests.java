package sof3as3a.harjoitustyo.treenipaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sof3as3a.harjoitustyo.treenipaivakirja.web.TreenilistaController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TreenipaivakirjaApplicationTests {
	
	@Autowired
	private TreenilistaController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
