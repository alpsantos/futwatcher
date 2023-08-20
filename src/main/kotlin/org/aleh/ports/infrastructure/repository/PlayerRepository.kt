package org.aleh.ports.infrastructure.repository

import jakarta.enterprise.context.ApplicationScoped
import org.aleh.domain.Player

@ApplicationScoped
class PlayerRepository {

    fun getPlayer (id: Int) : Player?  {
        return null
    }

    fun persist(player: Player) {

    }
}