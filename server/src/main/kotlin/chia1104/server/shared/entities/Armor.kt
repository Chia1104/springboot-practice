package chia1104.server.shared.entities

import chia1104.server.shared.dto.armor.NewArmor
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "armors")
class Armor (
    @Column(nullable = false)
    var name: String,

    @Column(nullable = true)
    var description: String,

    @Column(nullable = false)
    var image: String,

    @Column(nullable = false)
    var defense: Int,

    @Column(nullable = false)
    var level: Int,

    @Column(nullable = false)
    var heaviness: Int,
) {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID? = null

    companion object {
        fun create(newArmor: NewArmor): Armor {
            return Armor(
                newArmor.name,
                newArmor.description,
                newArmor.image,
                newArmor.defense,
                newArmor.level,
                newArmor.heaviness
            )
        }
    }
}