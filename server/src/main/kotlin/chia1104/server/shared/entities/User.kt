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
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    val id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    var name: String,

    @Column(nullable = false)
    @JsonIgnore
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: Role,

    @Column(nullable = false)
    var created_at: LocalDateTime = LocalDateTime.now(),
)