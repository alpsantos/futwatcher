package org.aleh.domain

import java.time.LocalDate

class Player {
    var id: Int
    var name: String
    var statusId: Status = Status.ACTIVE
    var createDate: LocalDate = LocalDate.now()

    var playerHistory: MutableList<PlayerHistory> = mutableListOf()

    constructor(
        id: Int,
        name: String,
        status: Status,
        createDate: LocalDate
    ) {
        this.id = id
        this.name = name
        this.statusId = status
        this.createDate = createDate
    }
}