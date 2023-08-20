package org.aleh.applicationservices.player

import jakarta.transaction.Transactional
import org.aleh.domain.Player
import org.aleh.ports.infrastructure.repository.PlayerRepository

class CreatePlayerServices(
    private val playerRepository: PlayerRepository
) {
    @Transactional
    fun createPlayer(player: Player) {
        playerRepository.persist(player)
    }
}