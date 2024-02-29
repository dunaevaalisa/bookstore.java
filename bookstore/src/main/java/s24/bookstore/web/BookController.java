package s24.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s24.bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;
import s24.bookstore.domain.BookRepository;;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Crime and punishment", "Dostoyevsky", 1867, 328923, 2390, 77));
        books.add(new Book("The idiot", "Dostoyevsky", 1869, 238492, 2903, 99));

        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));
        model.addAttribute("book", book);
        return "editbook";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }
}