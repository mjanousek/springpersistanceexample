package cz.janousek.web;

import cz.janousek.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

	private BookRepository bookRepository;

	@Autowired
	public BookRestController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(method = GET, produces = "application/json")
	public @ResponseBody List<Book> jsonBooks() {
		return bookRepository.findAll();
	}

	// first version
	@RequestMapping(value="/{title}", method = GET, produces = "application/json")
	public Book jsonBooks(@PathVariable String title) {
		return bookRepository.findByTitle(title);
	}

	// sencond version
	@RequestMapping(value="/v2/{title}", method = GET, produces = "application/json")
	public ResponseEntity<Book> jsonBooks2(@PathVariable String title) {
		Book book = bookRepository.findByTitle(title);
		HttpStatus status = book != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(book, status);
	}

	// co je spatne? Porad budu vrace prazdnou zpravu, ale uz se spravnym statusem. Jak to vyresit, abych nevratil
	// prazdnou zpravu, ale nejakou chybovou hlasku?
	@RequestMapping(value="/v3/{title}", method = GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Book jsonBooks3(@PathVariable String title) {
		Book book = bookRepository.findByTitle(title);
		if (book == null) {
			throw new BookNotFoundException("Knizka s titulem: " + title + " nenalezena");
		}
		return book;
	}

	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleNotFoundException(BookNotFoundException e) {
		return new Error(e.getMessage());
	}




	private class BookNotFoundException extends RuntimeException {
		private final String message;

		public BookNotFoundException(String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return this.message;
		}
	}
}
