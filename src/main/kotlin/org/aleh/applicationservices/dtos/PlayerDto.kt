package org.aleh.applicationservices.dtos

import org.aleh.domain.Player

class PlayerDto (player: Player) {
    var id : Int = player.id
    var name : String = player.name
    //var status : String = player.statusId.name
//    var createDade = player.createDate
}