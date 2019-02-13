package cz.janousek.web;

import cz.janousek.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/book")
public class BookController {

	private BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(value="/add", method = GET)
	public String showRegistrationForm() {
		return "bookForm";
	}

	@RequestMapping(value="/list", method = GET)
	public String showBook(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "books";
	}

	@RequestMapping(value="/{title}", method = GET)
	public String showBook(@PathVariable String title, Model model) {
		Book book = bookRepository.findByTitle(title);
		model.addAttribute("book", book);
		return "book";
	}

	@RequestMapping(value="/add", method = POST)
	public String processRegistration(@Valid Book book, Errors errors) {
		if (errors.hasErrors()) {
			return "bookForm";
		}

		bookRepository.save(book);
		return "redirect:/book/list";
	}
}

