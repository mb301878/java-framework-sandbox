package rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import rest.dto.Response2Dto;

import static org.assertj.core.api.BDDAssertions.then;
import static rest.Calls.sendGetToIncreaseVersion;

@AutoConfigureWebTestClient(timeout = "PT5S") // 5 sec
@SpringBootTest(classes = Runner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTestExample {

    @Autowired
    private WebTestClient webClient;

    @Test
    void increase_id() {
        int initialVersion = 2;
        Response2Dto actualResponse = sendGetToIncreaseVersion(webClient, initialVersion);

        then(actualResponse.getIncreasedId()).isEqualTo(initialVersion + 1);
    }

}
