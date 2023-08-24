package org.aleh.applicationservices.player

import io.mockk.every
import io.mockk.mockk
import org.aleh.domain.Player
import org.aleh.domain.Status
import org.aleh.ports.infrastructure.repository.PlayerRepository
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.BeforeTest

class GetPlayerServicesTest {

    private val playerRepository : PlayerRepository = mockk(relaxed = true)

    private lateinit var getPlayerServices: GetPlayerServices

    @BeforeTest
    fun setup() {
        getPlayerServices = GetPlayerServices(playerRepository)
    }

    @Test
    fun `it should get player by id`() {
        val fakePlayer = Player(1, "name",Status.ACTIVE.ordinal, LocalDate.now())

        every { playerRepository.getPlayer(any()) } returns fakePlayer

        val player = getPlayerServices.getPlayer(1)!!

        player.id shouldBeEqualTo  fakePlayer.id

    }
}