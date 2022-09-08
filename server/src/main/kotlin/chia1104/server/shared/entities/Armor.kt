package chia1104.server.shared.entities

import org.hibernate.annotations.Type
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "armors")
class Armor {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Type(type = "uuid-char")
    val id: String = ""

    @Column(nullable = false)
    var name: String = ""

    @Column(nullable = false)
    var description: String = ""

    @Column(nullable = false)
    var image: String = ""

    @Column(nullable = false)
    var defense: Int = 0

    @Column(nullable = false)
    var level: Int = 0

    @Column(nullable = false)
    var heaviness: Int = 0
}