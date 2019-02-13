package cz.janousek.data;

import cz.janousek.web.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByTitle(String title);
}
