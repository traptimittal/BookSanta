package com.booksanta.Resources;

import com.booksanta.Models.Book;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Trapti on 1/31/2015.
 */
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public BookResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    public Book getBook() {
        final String value = String.format(template, defaultName);
        return new Book(counter.incrementAndGet(), value);
    }
}
