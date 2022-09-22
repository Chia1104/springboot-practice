package chia1104.server.shared.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user_headgear")
class UserHeadgear (
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
    var level: Int,

    @Column(nullable = false)
    var heaviness: Int,
)