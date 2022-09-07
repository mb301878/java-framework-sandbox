package graphql.dao;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieRepo {

    public List<Movie> findAll() {
        return List.of(
                new Movie(1L, "Andrzej", "www.andrzej.com"),
                new Movie(2L, "Bendrzej", "www.bendrzej.com")
        );
    }
}
