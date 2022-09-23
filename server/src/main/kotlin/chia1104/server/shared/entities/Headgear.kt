package chia1104.server.shared.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import chia1104.server.shared.dto.headgear.NewHeadgear

@Entity
@Table(name = "headgears")
class Headgear (
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
        fun create(newHeadgear: NewHeadgear): Headgear {
            return Headgear(
                newHeadgear.name,
                newHeadgear.description,
                newHeadgear.image,
                newHeadgear.defense,
                newHeadgear.level,
                newHeadgear.heaviness
            )
        }
    }
}