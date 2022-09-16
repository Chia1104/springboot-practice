package chia1104.server.shared.dto.user

import chia1104.server.shared.enums.Role
import javax.validation.constraints.*
import chia1104.server.validation.annotation.Role as RoleAnnotation

class RegisterDto (
    @field:NotNull
    @field:Size(min = 1, max = 50)
    var name: String,

    @field:Email
    var email: String,

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var password: String,

    @field:RoleAnnotation
    var role: Role
)