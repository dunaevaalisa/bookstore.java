package s24.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String author;
    @Column(name = "publishing_year")
    private int publishingYear;
    private long isbn;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
    }

    public Book(String title, String author, int publishingYear, long isbn, double price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishingYear=" + publishingYear
                    + ", isbn=" + isbn + ", price=" + price + ", category=" + this.getCategory() + "]";
        else
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishingYear=" + publishingYear
                    + ", isbn=" + isbn + ", price=" + price + "]";
    }

}
