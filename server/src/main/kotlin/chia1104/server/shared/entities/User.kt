package chia1104.server.shared.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonFilter;
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

    @OneToOne
    var armor: UserArmor? = null,
) {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    val id: UUID? = null

    @Column(nullable = false)
    var created_at: LocalDateTime = LocalDateTime.now()
}