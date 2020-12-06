package net.javaguides.springboot.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "elements")
public class NewElement   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long link;

    @Column(name = "name")
    private String name;

    @Column(name = "summary")
    private String summary;

    @Column(name = "year")
    private String year;

    @Column(name = "country")
    private String country;

    @Column(name = "price")
    private String price;

    @Column(name = "description")
    private String description;

    public NewElement() {
    }

    public NewElement(String name, String summary, String year, String country, String price, String description) {
        this.name = name;
        this.summary = summary;
        this.year = year;
        this.country = country;
        this.price = price;
        this.description = description;
    }

    public long getLink() {
        return link;
    }

    public void setLink(long link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
