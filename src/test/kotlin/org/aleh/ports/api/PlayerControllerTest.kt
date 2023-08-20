package org.aleh.ports.api

import io.mockk.every
import io.mockk.mockk
import io.quarkiverse.test.junit.mockk.InjectMock
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.aleh.applicationservices.player.GetPlayerServices
import org.aleh.domain.Player
import org.aleh.domain.Status
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import java.time.LocalDate


@QuarkusTest
class PlayerControllerTest {

    @InjectMock
    private var getPlayerServices: GetPlayerServices = mockk(relaxed = true)

//    @Test
//    fun testHelloEndpoint() {
//        RestAssured.given()
//            .`when`().get("/api/player?id=1")
//            .then()
//            .statusCode(200)
//            .body(CoreMatchers.`is`("Hello RESTEasy"))
//    }

    @Test
    fun `it should return a detailed player`() {
        val fakePlayer = Player(1, "name", Status.ACTIVE, LocalDate.now())

        every {
            getPlayerServices.getPlayer(any())
        } returns fakePlayer

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
}