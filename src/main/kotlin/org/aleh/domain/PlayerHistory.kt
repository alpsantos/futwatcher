package org.aleh.domain

import java.math.BigInteger
import java.time.LocalDateTime

class PlayerHistory {
    val id: BigInteger = BigInteger.ZERO
    val price:  Double = 0.0
    val playerId: Int = 0
    val createDate: LocalDateTime = LocalDateTime.now()
}