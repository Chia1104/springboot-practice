package chia1104.server.shared.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import chia1104.server.shared.enums.Role
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
class User (
    @Column(nullable = false)
    var name: String,

    @Column(unique = true, nullable = false)
    var email: String,

    @Column(nullable = false)
    @JsonIgnore
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: Role,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "armor_id", referencedColumnName = "id")
    var armor: UserArmor? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "headgear_id", referencedColumnName = "id")
    var headgear: UserHeadgear? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shield_id", referencedColumnName = "id")
    var shield: UserShield? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weapon_id", referencedColumnName = "id")
    var weapon: UserWeapon? = null,
) {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID? = null

    @Column(nullable = false)
    var created_at: LocalDateTime = LocalDateTime.now()
}