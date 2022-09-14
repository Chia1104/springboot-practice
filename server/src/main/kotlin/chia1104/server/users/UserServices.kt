package chia1104.server.users

import chia1104.server.shared.entities.User
import chia1104.server.shared.dto.user.RegisterDto
import org.springframework.stereotype.Service
import java.util.*
import chia1104.server.utils.HashUtils
import org.springframework.http.HttpStatus.*
import org.springframework.web.server.ResponseStatusException

@Service
class UserServices(
    private val repository: UserRepositories,
) {
    fun createUser(user: RegisterDto): User {
        if (repository.findByName(user.name) != null) {
            throw ResponseStatusException(BAD_REQUEST, "User already exists")
        }
        val hashUtils = HashUtils()
        val hashed = hashUtils.hashPassword(user.password)
        return repository.save(User(
            name = user.name,
            password = hashed,
            role = user.role
        ))
    }
}