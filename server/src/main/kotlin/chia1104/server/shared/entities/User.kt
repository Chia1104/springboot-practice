package chia1104.server.shared.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Type
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import chia1104.server.shared.enums.Role

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Type(type = "uuid-char")
    val id: String = ""

    @Column(nullable = false)
    var name: String = ""

    @Column(unique = true, nullable = false)
    var email: String = ""

    @Column(nullable = false)
    @JsonIgnore
    var password: String = ""

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: Role = Role.Archer

    @Column(nullable = false)
    var created_at: Date = Date()
}