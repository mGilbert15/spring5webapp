package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Represents a Book Publisher.
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private int zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<Book>();

    /**
     * Default Publisher Constructor.
     */
    public Publisher() {
    }

    /**
     * Create a Publisher Object with a given name and address details
     * code
     * 
     * @param name the name of the publisher
     * @param addressLine1 street address of the publisher
     * @param city         city where publisher is located
     * @param state        state where publisher is located
     * @param zip          zip where publisher is located
     */
    public Publisher(String name, String addressLine1, String city, String state, int zip) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Get's the name of the publisher.
     * @return the name of the publisher.
     */
    public String getName() {
        return name;
    }


    /**
     * Update's the name of the publisher.
     * @param name the new name of the publisher
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the ID of the publisher.
     * 
     * @return id of the publisher.
     */
    public Long getId() {
        return id;
    }


    /**
     * Update the ID of the publisher.
     * 
     * @param id new publisher ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get's the first address line of where the publisher is located (typically
     * building # and street)
     * 
     * @return the first address line of where the publisher is located
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Updates the first address line of where the publisher is located (typically
     * building # and street)
     * 
     * @param addressLine1 the new first address line of the publisher (typically
     *                     building # and street)
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Get's the City where the publisher is located.
     * 
     * @return the city where the publisher is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Update's the city where the publisher is located.
     * 
     * @param city the city where the publisher is now located.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get's the state where the Publisher is located.
     * 
     * @return the state where the Publisher is located.
     */
    public String getState() {
        return state;
    }

    /**
     * Updates the state where the publisher is located.
     * 
     * @param state the state where the publisher is now located.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get's the zip code where the publisher is located.
     * 
     * @return the zip code where the publisher is located.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Get's all the books that the Publisher has published.
     * @return all the books the publisher published
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * Updates the books a publisher has published.
     * @param books the updated list of books a published
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**
     * Updates the zipcode of the Publisher.
     * 
     * @param zip the updated publisher zipcode
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Checks to see both objects belong to publisher class and have the same id.
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
     * Creates String format of Author displaying set of books, first name,
     * lastname, and id.
     */
    @Override
    public String toString() {
        return "Publisher [name=" + name + " addressLine1=" + addressLine1 + ", city=" + city + ", id=" + id + ", state=" + state
                + ", zip=" + zip + "]";
    }

}
