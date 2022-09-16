package chia1104.server.users

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import chia1104.server.shared.entities.User
import chia1104.server.shared.dto.user.RegisterDto
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import org.springframework.http.HttpStatus.*

@RestController
@RequestMapping("/api/user")
class UserControllers(private val service: UserServices) {
    @PostMapping("/register")
    fun login(
        @Valid
        @RequestBody
        dto: RegisterDto
    ): User {
        try {
            return service.createUser(dto)
        } catch (e: Exception) {
            if (e is IllegalArgumentException) {
                throw ResponseStatusException(BAD_REQUEST, e.message)
            }
            throw ResponseStatusException(INTERNAL_SERVER_ERROR, e.message)
        }
    }
}