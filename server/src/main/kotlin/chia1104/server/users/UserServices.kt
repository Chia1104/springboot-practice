package chia1104.server.users

import chia1104.server.shared.dto.user.LoginDto
import chia1104.server.shared.entities.User
import chia1104.server.shared.dto.user.RegisterDto
import org.springframework.stereotype.Service
import chia1104.server.utils.HashUtils
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import java.time.Instant
import java.util.*

@Service
class UserServices(
    private val repository: UserRepositories,
    private val hashUtils: HashUtils,
    private val jwtEncoder: JwtEncoder
) {

    fun generateToken(user: User): String {
        val now: Instant = Instant.now()

        val claims = JwtClaimsSet.builder()
            .subject(user.name)
            .claim("id", user.id)
            .claim("email", user.email)
            .claim("name", user.name)
            .claim("roles", user.role)
            .build()

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }

    fun createUser(user: RegisterDto): User {
        if (repository.findByEmail(user.email) != null) {
            throw IllegalArgumentException("Email already exists")
        }
        val hashed = hashUtils.hashPassword(user.password)
        return repository.save(User(
            name = user.name,
            email = user.email,
            password = hashed,
            role = user.role
        ))
    }

    fun login(user: LoginDto): User {
        val u = repository.findByEmail(user.email) ?: throw IllegalArgumentException("User not found")
        if (!hashUtils.checkPassword(user.password, u.password)) {
            throw IllegalArgumentException("Password is incorrect")
        }
        return u
    }

    fun getUser(id: UUID): User {
        return repository.findById(id).orElseThrow { IllegalArgumentException("User not found") }
    }

    fun getAllUsers(): List<User> {
        return repository.findAll()
    }
}