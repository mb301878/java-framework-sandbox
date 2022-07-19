package rest;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import rest.dto.Request1Dto;
import rest.dto.Response1Dto;
import rest.dto.Response2Dto;

class Handler {

    public Mono<ServerResponse> doTea(ServerRequest request) {
        return request.bodyToMono(Request1Dto.class)
                .map(dto -> doSomethingAndReturnDummyResponse(dto.getName()))
                .flatMap(ResponseRenderer::renderResponseAccepted);
    }

    public Mono<ServerResponse> increaseId(ServerRequest request) {
        return Mono.just(request)
                .map(req -> readParamFromRequest(req, "idToIncrease"))
                .map(id -> id + 1)
                .map(Response2Dto::newInstance)
                .flatMap(ResponseRenderer::renderResponseAccepted);

    }

    private Response1Dto doSomethingAndReturnDummyResponse(String justRandomArgument) {
        return Response1Dto.newInstance(justRandomArgument + "czaj", true);
    }

    private Long readParamFromRequest(ServerRequest request, String pathVariable) {
        String variable = request.pathVariable(pathVariable);
        return Long.parseLong(variable);
    }
}
