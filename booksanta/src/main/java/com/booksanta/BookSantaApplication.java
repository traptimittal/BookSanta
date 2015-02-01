package com.booksanta;

import com.booksanta.Resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class BookSantaApplication extends Application<BookSantaConfiguration> {
    public static void main(String[] args) throws Exception {
        new BookSantaApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<BookSantaConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(BookSantaConfiguration configuration,
                    Environment environment) {
        final BookResource resource = new BookResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}
