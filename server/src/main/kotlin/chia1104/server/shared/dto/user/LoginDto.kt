package chia1104.server.shared.dto.user

import javax.validation.constraints.*

class LoginDto (
    @field:Email
    var email: String,

    @field:NotNull
    @field:Size(min = 1, max = 50)
    var password: String,
)