package s24.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import s24.bookstore.domain.Book;
import s24.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Crime and punishment", "Dostoyevsky", 1867, 328923, 2390, 77));
			repository.save(new Book("The idiot", "Dostoyevsky", 1869, 238492, 2903, 99));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("haetaan kaikki Naamiot");
			for (Book book : repository.findByTitle("Naamio")) {
				log.info(book.toString());
			}

		};
	}
}
