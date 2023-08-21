package org.aleh.ports.infrastructure.repository

import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.NoResultException
import jakarta.transaction.Transactional
import org.aleh.domain.Player

@ApplicationScoped
class PlayerRepository : Repository() {

    fun getPlayer(id: Int): Player? {
        return try {
            entityManager!!
                .createQuery("SELECT p FROM Player p WHERE p.id = :id")
                .setParameter("id", id)
                .singleResult as Player
        } catch (e: NoResultException) {
            null
        }
    }

    @Transactional
    fun persist(player: Player) {
        entityManager!!.merge(player)
        entityManager!!.flush()
    }
}