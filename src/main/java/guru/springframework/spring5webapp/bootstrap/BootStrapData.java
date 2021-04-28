package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;

import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    
    /**
     * Creates BootStrap data with given author and book repositories.
     * @param authorRepository the AuthorRepository to bootstrap
     * @param bookRepository the BookRepository to bootstrap
     * @param publisherRepository the PublisherRepository to bootstrap
     */
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        System.out.println("There are currently " + this.bookRepository.count() + " books in the repository");
        
        //Creating a test publisher object
        Publisher penguin = new Publisher("Penguin Books", "Street", "City", "State", 29185);
        this.publisherRepository.save(penguin);
        



        System.out.println("There are currently " + this.publisherRepository.count() + " publishers in the repository");
        System.out.println("Publisher list " + this.publisherRepository.findAll());
        
    }
    
}
