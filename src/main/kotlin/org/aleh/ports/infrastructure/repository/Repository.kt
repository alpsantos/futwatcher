package org.aleh.ports.infrastructure.repository

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.persistence.EntityManager

@ApplicationScoped
class Repository {

    @Inject
    protected var entityManager: EntityManager? = null

}