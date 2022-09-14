package chia1104.server.shared.dto.user

import chia1104.server.shared.enums.Role

class RegisterDto (
    var name: String,
    var password: String,
    var role: Role
)