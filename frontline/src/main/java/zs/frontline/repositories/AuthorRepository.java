package zs.frontline.repositories;

import org.springframework.data.repository.CrudRepository;
import zs.frontline.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
