package com.booksanta.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Trapti on 2/1/2015.
 */
public class Book {
    private long id;

    @Length(max = 3)
    private String content;

    public Book() {
        // Jackson deserialization
    }

    public Book(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
