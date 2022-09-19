package chia1104.server.shared.entities

import org.hibernate.annotations.Type
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

class UserArmor (
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @OneToOne
    @JoinColumn(name = "armor_id")
    val armor: Armor,
)