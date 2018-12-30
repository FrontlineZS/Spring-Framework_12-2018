package zs.frontline.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zs.frontline.model.Author;
import zs.frontline.model.Book;
import zs.frontline.model.Publisher;
import zs.frontline.repositories.AuthorRepository;
import zs.frontline.repositories.BookRepository;
import zs.frontline.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		initData();
	}

	private void initData() {

		Publisher publisher = new Publisher();
		publisher.setName("Radoslaw");
		publisher.setAddress("5 Lipca 22b");

		publisherRepository.save(publisher);

		// Eric
		Author eric = new Author("Eric", "Evans");
		Book domainDrivenDesign = new Book("Domain Driven Design", "1234", publisher);

		eric.getBooks().add(domainDrivenDesign);
		domainDrivenDesign.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(domainDrivenDesign);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "4321", publisher);

		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}
}
