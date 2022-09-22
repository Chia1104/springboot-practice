package chia1104.server.shared.entities

import org.hibernate.annotations.GenericGenerator
import chia1104.server.shared.enums.WeaponCategory
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "weapons")
class Weapon (
    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var description: String,

    @Column(nullable = false)
    var image: String,

    @Column(nullable = false)
    var defense: Int,

    @Column(nullable = false)
    var attack: Int,

    @Column(nullable = false)
    var level: Int,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var category: WeaponCategory,

    @Column(nullable = false)
    var heaviness: Int,
) {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID? = null
}