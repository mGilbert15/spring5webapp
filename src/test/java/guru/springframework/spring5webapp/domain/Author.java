package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import java.util.Set;

/**
 * Represents an Author of a Book.
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    /**
     * Default Author constructor.
     */
    public Author() {
    }

    /**
     * Creates an Author with a given first and last name.
     * @param firstName first name of the author
     * @param lastName last name of the author
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the Id of the Author.
     * @return the author's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the Author ID.
     * @param id the new author id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get's the author's first name.
     * @return the author's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the author's first name to a given string value.
     * @param firstName the new author first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get's the Author's Last name.
     * @return the author's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the author's last name to a given string value.
     * @param lastName the new author last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets a list of unique books that the author has written.
     * @return list of unqiue books the author has written.
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * Sets a unique set of books that the author has written.
     * @param books the new set of books the author has written
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Checks to see if the given object is an Author and if it has the same id. If so returns true else returns false.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass())
            return false;

        Author other = (Author) obj;
        if (id != null && !id.equals(other.getId())) {
            return true;
        } 

        return false;
    }

    /**
     * String representing the author includes info about books the author has written, firstname, lastname, id and isbn.
     */
    @Override
    public String toString() {
        return "Author [books=" + books + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }
}
