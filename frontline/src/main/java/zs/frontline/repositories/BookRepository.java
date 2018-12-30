package zs.frontline.repositories;

import org.springframework.data.repository.CrudRepository;
import zs.frontline.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
