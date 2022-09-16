package chia1104.server.shared.dto.armor

import javax.validation.constraints.*

class NewArmor (
    @field:NotNull
    @field:Size(min = 1, max = 20)
    var name: String,

    @field:NotNull
    @field:Size(min = 1, max = 100)
    var description: String,

    @field:NotNull
    var image: String,

    @field:NotNull
    @field:Min(0)
    @field:Max(100)
    var defense: Int,

    @field:NotNull
    @field:Min(0)
    @field:Max(5)
    var level: Int,

    @field:NotNull
    @field:Min(0)
    @field:Max(100)
    var heaviness: Int,
)