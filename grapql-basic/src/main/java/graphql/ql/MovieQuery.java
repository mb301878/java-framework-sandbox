package graphql.ql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.MovieService;
import graphql.dao.Movie;
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
