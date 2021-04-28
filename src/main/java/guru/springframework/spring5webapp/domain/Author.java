package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    /**
     * Default no-arg constructor.
     */
    public Author() {

    }

    /**
     * Creates a new author with a given first and last name and a set of books that
     * the author wrote.
     * 
     * @param firstName first name of author
     * @param lastName  last name of author
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the author.
     * 
     * @return author's first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of the author.
     * 
     * @return author's last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets a set of books written by the author.
     * 
     * @return set of books written by the author.
     */
    public Set<Book> getBooks() {
        return this.books;
    }

    /**
     * Gets the id of the author.
     * 
     * @return the id of the author.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the first name of the author.
     * 
     * @param firstName the author's changed first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Changes the value of the last name of the author.
     * 
     * @param lastName the author's new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Changes the value of the books that the author has written.
     * 
     * @param books the updated set of books the author has written
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**
     * Changes the value of the id of the author.
     * 
     * @param id the author's new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Checks to see both objects belong to author class and have the same id.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj.getClass() == this.getClass()) {
            Author other = (Author) obj;
            return this.id != null && other.getId() != null && this.id == other.getId();
        }

        return false;
    }

    /**
     * Creates String format of Author displaying set of books, first name, lastname, and id.
     */
    @Override
    public String toString() {
        return "Author [books=" + books + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
