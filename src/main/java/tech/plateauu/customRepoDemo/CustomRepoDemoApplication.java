package tech.plateauu.customRepoDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.plateauu.customRepoDemo.repository.PersonInput;
import tech.plateauu.customRepoDemo.repository.PersonInputRepository;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class CustomRepoDemoApplication implements CommandLineRunner {

	private final PersonInputRepository personInputRepository;

	private static final Logger log = LoggerFactory.getLogger(CustomRepoDemoApplication.class.getName());

	public CustomRepoDemoApplication(PersonInputRepository personInputRepository) {
		this.personInputRepository = personInputRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomRepoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PersonInput person = new PersonInput();
		person.setEmail("some@email.address.com");
		person.setName("Martin");
		person.setSurname("Michalak");
		personInputRepository.save(person);

		PersonInput person2 = new PersonInput();
		person2.setEmail("some2@second.address.com");
		person2.setName("Second");
		person2.setSurname("Michalak");
//		personInputRepository.saveAllPersonFromCollection(Collections.singletonList(person2));

		List<PersonInput> list = personInputRepository.findAllByName("Martin");
		list.forEach(in -> log.info("its: "+ in.toString()));
	}
}
