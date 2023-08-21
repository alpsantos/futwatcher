package org.aleh.domain


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "player")
open class Player {
    @Id
    open var id: Int = 0

    @Column(name = "name", columnDefinition = "varchar" )
    open var name: String = ""
    //var statusId: Status = Status.ACTIVE
    @Column(name = "player_status_id", columnDefinition = "int" )
    open var statusId: Int = 0

//    @Basic(fetch = LAZY)
//    @Column(name = "create_date")
//    var createDate: LocalDate

    //var playerHistory: MutableList<PlayerHistory> = mutableListOf()
    constructor()
    constructor(
        id: Int,
        name: String,
        statusId: Int,
        createDate: LocalDate
    ) {
        this.id = id
        this.name = name
        this.statusId = statusId
//        this.createDate = createDate
    }
}