package chia1104.server.shared.entities

import org.hibernate.annotations.Type
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_armor")
class UserArmor (
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID = UUID.randomUUID(),

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "armor_id", referencedColumnName = "id")
    val armor: Armor,
)