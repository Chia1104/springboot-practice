package chia1104.server.shared.entities

import org.hibernate.annotations.Type
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

class UserArmor (
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    val id: UUID,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "armor_id")
    val armor: Armor,
)