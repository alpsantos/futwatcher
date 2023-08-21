package org.aleh.applicationservices.player

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.aleh.domain.Player
import org.aleh.ports.infrastructure.repository.PlayerRepository

@ApplicationScoped
class CreatePlayerServices
@Inject
constructor(
    private val playerRepository: PlayerRepository
) {
    @Transactional
    fun createPlayer(player: Player) {
        playerRepository.persist(player)
    }
}