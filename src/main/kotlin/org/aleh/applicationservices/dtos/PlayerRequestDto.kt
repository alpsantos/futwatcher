package org.aleh.applicationservices.dtos

import com.fasterxml.jackson.annotation.JsonProperty

class PlayerRequestDto(
    @JsonProperty("id")
    var id: Int
)