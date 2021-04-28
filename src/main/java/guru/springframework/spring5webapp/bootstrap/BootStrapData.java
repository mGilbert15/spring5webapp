package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    
    /**
     * Creates BootStrap data with given author and book repositories.
     * @param authorRepository the AuthorRepository to bootstrap
     * @param bookRepository theBookRepository to bootstrap
     */
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author jane = new Author("Jane", "Austin");
        Book prideAndPrejudice = new Book("Pride and Prejudice", "184249320");

        jane.getBooks().add(prideAndPrejudice);
        prideAndPrejudice.getAuthors().add(jane);

        this.authorRepository.save(jane);
        this.bookRepository.save(prideAndPrejudice);


        Author brandon = new Author("Brandon", "Mull");
        Book fablehaven = new Book("Fabelhaven", "14310893");

        brandon.getBooks().add(fablehaven);
        fablehaven.getAuthors().add(brandon);

        this.authorRepository.save(brandon);
        this.bookRepository.save(fablehaven);

        System.out.println("Bootstrapping data...");
        System.out.println("There are currently " + this.bookRepository.count() + " in the repository");
        
    }
    
}
