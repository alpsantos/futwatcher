package org.aleh.ports.api

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.quarkiverse.test.junit.mockk.InjectMock
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import io.restassured.http.ContentType
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.aleh.applicationservices.dtos.PlayerResponseDto
import org.aleh.applicationservices.player.CreatePlayerServices
import org.aleh.applicationservices.player.GetPlayerServices
import org.aleh.domain.Player
import org.aleh.domain.Status
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import java.net.http.HttpHeaders
import java.time.LocalDate


@QuarkusTest
class PlayerControllerTest {

    @InjectMock
    private var getPlayerServices: GetPlayerServices = mockk(relaxed = true)

    @InjectMock
    private var createPlayerServices: CreatePlayerServices = mockk(relaxed = true)

    @Test
    fun `it should return a detailed player`() {

        val fakePlayer = Player(1, "name", Status.ACTIVE.ordinal, LocalDate.now())

        every {
            getPlayerServices.getPlayer(any())
        } returns PlayerResponseDto(fakePlayer)

        RestAssured.given()
            .`when`()
            .get("/api/player?id=1")
            .then()
            .statusCode(200)
            .body(
                "id", equalTo(1),
                "name", equalTo("name")
            )
    }

    @Test
    fun `it should create a new player`() {

        every {
            createPlayerServices.createPlayer(any())
        } just Runs

        RestAssured.given()
            .contentType(ContentType.JSON)
            .body("{\"id\": 2, \"name\": \"name2\"}")
            .`when`().post("/api/player")
            .then().statusCode(Response.Status.CREATED.statusCode)

//        RestAssured
//            .with()
//            .body("{\"id\": 2, \"name\": \"name2\"}")
//            .`when`()
//            .request("POST", "/api/player")
//            .then()
//            .statusCode(201)

//        RestAssured.given()
//            .body("{\"id\": 2, \"name\": \"name2\"}")
//            .header("Content-Type", MediaType.APPLICATION_JSON)
//            .post("/api/player")
//            .then()
//            .statusCode(201)
    }
}