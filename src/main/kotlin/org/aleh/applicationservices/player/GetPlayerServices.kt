package org.aleh.applicationservices.player;

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
//import javax.enterprise.context.ApplicationScoped
//import javax.inject.Inject
import org.aleh.domain.Player
import org.aleh.ports.infrastructure.repository.PlayerRepository

@ApplicationScoped
class GetPlayerServices
@Inject
constructor(
    val playerRepository: PlayerRepository
) {

    fun getPlayer(id: Int): Player? {
        val player = playerRepository.getPlayer(id) ?: return null
        return player
    }
}

