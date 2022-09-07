package graphql.ql;

import graphql.MovieService;
import graphql.dao.Movie;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MovieQuery implements GraphQLQueryResolver {

    private final MovieService movieService;

    public List<Movie> getMovies(int limit) {
        return movieService.get(limit);
    }


}
