package rest;

import lombok.experimental.UtilityClass;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import rest.dto.Request1Dto;
import rest.dto.Response1Dto;
import rest.dto.Response2Dto;

@UtilityClass
class Calls {

    public static Response2Dto sendGetToIncreaseVersion(WebTestClient webClient, int idToIncrease) {
        return webClient.get()
                .uri(Router.ROUTE + "increaseId/" + idToIncrease)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Response2Dto.class)
                .returnResult()
                .getResponseBody();
    }

    public static Response1Dto sendPostToDummyEndpoint(WebTestClient webClient, String message) {
        return webClient.post()
                .uri(Router.ROUTE + "post-example")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Request1Dto(message)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Response1Dto.class)
                .returnResult()
                .getResponseBody();
    }
}
