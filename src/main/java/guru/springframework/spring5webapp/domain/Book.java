package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

/**
 * Represents a Book.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<Author>();

    /**
     * Default Book Constructor.
     */
    public Book() {
    }

    /**
     * Creates a book with a given tile and isbn number.
     * @param title title of the book
     * @param isbn isbn number of the book
     */
    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    /**
     * Gets the book Id.
     * @return G
     */
    public Long getId() {
        return id;
    }

    /**
     * Updates the id of the book to the given value.
     * @param id the new book id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get's the title of the book.
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the title of the book to the given value.
     * @param title the new book title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get's the ISBN number of the Book.
     * @return  the ISBN number of the book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * update the Book's ISBN number to the given value.
     * @param isbn the new isbn number
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get's a list of unique authors that wrote the book.
     * @return  list of unique authors that wrote the book
     */
    public Set<Author> getAuthors() {
        return authors;
    }

    /**
     * Reset the authors that wrote the book to a new given value.
     * @param authors new list of authors that wrote the book
     */
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    /**
     * Checks to see if the given object is an Book and if it has the same id. If so returns true else returns false.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass())
            return false;

        Book other = (Book) obj;
        if (this.id != null && !this.id.equals(other.getId())) {
            return true;
        } 

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    /**
     * String representing the Book includes info about book such as list of unique authors, id, isbn, and title.
     */
    @Override
    public String toString() {
        return "Book [authors=" + authors + ", id=" + id + ", isbn=" + isbn + ", title=" + title + "]";
    }

}