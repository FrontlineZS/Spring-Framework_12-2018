package zs.frontline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zs.frontline.model.Author;
import zs.frontline.model.Book;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FrontlineApplication {

	public static void main(String[] args) {

		SpringApplication.run(FrontlineApplication.class, args);

		Book book1 = new Book("title1", "isbn1", "publisher1");
		Book book2 = new Book("title2", "isbn2", "publisher2");

		Set<Book> bookSet = new HashSet<>();
		bookSet.add(book1);
		bookSet.add(book2);

		Author author = Author.NameAndSurname("Radosław", "Kochaniuk");
		Author authorWithBooks = Author.NameSurnameAndBooks("Radosław", "Kochaniuk", bookSet);

		System.out.println("Author id: " + author.getId());
		System.out.println("Author's name: " + author.getFirstName() + " " + author.getLastName());

		System.out.println("AuthorWithBooks's books: " + authorWithBooks.getBooks());
	}

}

