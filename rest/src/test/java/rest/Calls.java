package rest;

import lombok.experimental.UtilityClass;
import org.springframework.test.web.reactive.server.WebTestClient;
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
}
