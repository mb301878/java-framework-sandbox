package graphql;

import graphql.dao.Movie;
import graphql.dao.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepo movieRepo;

    public List<Movie> get(long count) {
        return movieRepo
                .findAll()
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
