package chia1104.server.users

import chia1104.server.shared.dto.user.LoginDto
import org.springframework.web.server.ResponseStatusException
import chia1104.server.shared.entities.User
import chia1104.server.shared.dto.user.RegisterDto
import javax.validation.Valid
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/user")
class UserControllers(private val service: UserServices) {
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: UUID): User {
        try {
            return service.getUser(id)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @GetMapping("/all")
    fun getAllUsers(): List<User> {
        try {
            return service.getAllUsers()
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }
}