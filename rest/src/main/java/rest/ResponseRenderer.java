package rest;

import lombok.experimental.UtilityClass;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.logging.Level;

@UtilityClass
class ResponseRenderer {

    private final String ERROR_MESSAGE = "i am a teapot heh";

    Mono<ServerResponse> renderResponseAccepted(Object dto) {
        return ServerResponse.accepted()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(dto))
                .onErrorResume(ResponseRenderer::getErrorResponse);
    }

    private Mono<ServerResponse> getErrorResponse(Throwable e) {
        return getErrorResponse();
    }

    private Mono<ServerResponse> getErrorResponse() {
        return ServerResponse.status(HttpStatus.I_AM_A_TEAPOT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(ERROR_MESSAGE))
                .log(ERROR_MESSAGE + " and i am logging it", Level.WARNING);
    }
}
