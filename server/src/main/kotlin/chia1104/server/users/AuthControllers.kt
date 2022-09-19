package chia1104.server.users

import chia1104.server.shared.dto.user.LoginDto
import org.springframework.web.server.ResponseStatusException
import chia1104.server.shared.dto.user.RegisterDto
import javax.validation.Valid
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthControllers(private val service: UserServices) {
    @PostMapping("/register")
    fun register(
        @Valid
        @RequestBody
        dto: RegisterDto,
    ): Map<String, Any> {
        try {
            val user = service.createUser(dto)
            val token = service.generateToken(user)
            return mapOf(
                "user" to user,
                "token" to token
            )
        } catch (e: Exception) {
            if (e is IllegalArgumentException) {
                throw ResponseStatusException(BAD_REQUEST, e.message)
            }
            throw ResponseStatusException(INTERNAL_SERVER_ERROR, e.message)
        }
    }

    @PostMapping("/login")
    fun login(
        @Valid
        @RequestBody
        dto: LoginDto,
    ): Map<String, Any> {
        try {
            val user = service.login(dto)
            val token = service.generateToken(user)
            return mapOf(
                "user" to user,
                "token" to token
            )
        } catch (e: Exception) {
            if (e is IllegalArgumentException) {
                throw ResponseStatusException(BAD_REQUEST, e.message)
            }
            throw ResponseStatusException(INTERNAL_SERVER_ERROR, e.message)
        }
    }
}