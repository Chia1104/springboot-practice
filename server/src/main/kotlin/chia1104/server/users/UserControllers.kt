package chia1104.server.users

import org.springframework.web.server.ResponseStatusException
import chia1104.server.shared.entities.User
import javax.validation.Valid
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/user")
@CrossOrigin
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

    @PutMapping("/armor")
    fun updateArmor(
        @Valid
        @RequestParam
        armorId: UUID,
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.updateUserArmor(formatToken, armorId)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @DeleteMapping("/armor")
    fun deleteArmor(
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.removeUserArmor(formatToken)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @PutMapping("/weapon")
    fun updateWeapon(
        @Valid
        @RequestParam
        weaponId: UUID,
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.updateUserWeapon(formatToken, weaponId)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @DeleteMapping("/weapon")
    fun deleteWeapon(
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.removeUserWeapon(formatToken)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @PutMapping("/headgear")
    fun updateHeadgear(
        @Valid
        @RequestParam
        headgearId: UUID,
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.updateUserHeadgear(formatToken, headgearId)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @DeleteMapping("/headgear")
    fun deleteHeadgear(
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.removeUserHeadgear(formatToken)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @PutMapping("/shield")
    fun updateShield(
        @Valid
        @RequestParam
        shieldId: UUID,
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.updateUserShield(formatToken, shieldId)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }

    @DeleteMapping("/shield")
    fun deleteShield(
        @RequestHeader("Authorization")
        token: String
    ): User {
        try {
            val formatToken = token.substring(7)
            return service.removeUserShield(formatToken)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, e.message)
        }
    }
}