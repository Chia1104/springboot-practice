package chia1104.server.shared.dto.armor

import javax.persistence.Column

class NewArmor (
    var name: String,
    var description: String,
    var image: String,
    var defense: Int,
    var level: Int,
    var heaviness: Int,
)