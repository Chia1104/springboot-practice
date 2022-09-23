package chia1104.server.shared.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import chia1104.server.shared.dto.shield.NewShield

@Entity
@Table(name = "shields")
class Shield (
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

    @Column(nullable = false)
    var heaviness: Int,
) {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID? = null

    companion object {
        fun create(dto: NewShield) = Shield(
            name = dto.name,
            description = dto.description,
            image = dto.image,
            defense = dto.defense,
            attack = dto.attack,
            level = dto.level,
            heaviness = dto.heaviness
        )
    }
}