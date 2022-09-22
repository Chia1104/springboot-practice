package chia1104.server.shared.dto.weapon

import chia1104.server.validation.annotation.WeaponCategory as WeaponCategoryAnnotation
import chia1104.server.shared.enums.WeaponCategory
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class NewWeapon (
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
    @field:Max(100)
    var attack: Int,

    @field:NotNull
    @field:Min(0)
    @field:Max(5)
    var level: Int,

    @field:NotNull
    @field:Min(0)
    @field:Max(100)
    var heaviness: Int,

    @field:WeaponCategoryAnnotation
    var category: WeaponCategory
)