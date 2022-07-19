package rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import rest.dto.Request1Dto;
import rest.dto.Response1Dto;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Router {

    static final String ROUTE = "/api-example/";
    private final Handler handler;

    @Autowired
    Router() {
        handler = new Handler();
    }

    @Bean
    public RouterFunction<ServerResponse> versionRoute() {
        return RouterFunctions
                .route(GET(ROUTE + "increaseId/{idToIncrease}"), handler::increaseId);
    }

    @Bean
    @RouterOperation(operation = @Operation(operationId = "operationOne", summary = "Do something",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Request1Dto.class))),
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Celebrating this beautiful day.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response1Dto.class)))}))
    public RouterFunction<ServerResponse> doExampleOfPost() {
        return RouterFunctions.route(POST(ROUTE + "post-example").and(accept(MediaType.APPLICATION_JSON)), handler::doTea);
    }




}
