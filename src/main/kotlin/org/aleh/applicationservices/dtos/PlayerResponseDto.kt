package org.aleh.applicationservices.dtos

import org.aleh.domain.Player

class PlayerResponseDto (player: Player) {
    var id : Int = player.id
    var name : String = player.name
    var status : Int = player.statusId
    var createDade = player.createDate
}