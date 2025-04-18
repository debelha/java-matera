package com.matera.ContaService;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.matera.ContaService.repository.ContaRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContaControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @RegisterExtension
    static WireMockExtension wireMockServer = WireMockExtension.newInstance()
            .options(
                        wireMockConfig().dynamicPort().httpDisabled(true)
            )
            .build();

    @Autowired
    private ContaRepository contaRepository;

    public void setUp() {
        RestAssured.port = port;
    }

    @AfterEach
    void afterEach() {
        clearDatabase(contaRepository);
    }

    protected void clearDatabase(JpaRepository... repositories) {
        Arrays.stream(repositories).forEach(CrudRepository::deleteAll);
    }

    @Test
    void deveCriarContaComSucesso() throws IOException {
        String request = new String(Files.readString(Paths.get("src/test/resources/request-conta.json")));

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/api/contas")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", notNullValue())
                .body("nome", equalTo("Felipe"));
    }
}
