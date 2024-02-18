package syn.lessons.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import syn.lessons.quotes.services.BashParser;
import syn.lessons.quotes.services.QuoteService;

@SpringBootApplication
public class QuotesApplication implements CommandLineRunner {
@Autowired
QuoteService service;

	public static void main(String[] args) {
		SpringApplication.run(QuotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var index = service.getIndex();
		System.out.println(index);
	}
}
