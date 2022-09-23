package chia1104.server.shared.entities

import chia1104.server.shared.enums.WeaponCategory
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_weapon")
class UserWeapon (
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID = UUID.randomUUID(),

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val user: List<User> = emptyList(),

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
    companion object {
        fun create(
            name: String,
            description: String,
            image: String,
            defense: Int,
            attack: Int,
            level: Int,
            category: WeaponCategory,
            heaviness: Int,
        ) = UserWeapon(
            name = name,
            description = description,
            image = image,
            defense = defense,
            attack = attack,
            level = level,
            category = category,
            heaviness = heaviness,
        )
    }
}