package chia1104.server.shields

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid
import chia1104.server.shared.entities.Shield
import chia1104.server.shared.dto.shield.NewShield

@RestController
@RequestMapping("/api/shield")
@CrossOrigin
class ShieldControllers(private val service: ShieldServices) {
    @GetMapping("/all")
    fun getAllShields(): List<Shield> = service.getAllShields()

    @GetMapping("/{id}")
    fun getShieldById(@PathVariable id: UUID): Optional<Shield> {
        try {
            return service.getShieldById(id)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, "Shield not found")
        }
    }

    @PostMapping("/add")
    fun addShield(
        @Valid
        @RequestBody
        newShield: NewShield
    ): Shield {
        try {
            return service.createShield(newShield)
        } catch (e: Exception) {
            throw ResponseStatusException(BAD_REQUEST, "Shield not added")
        }
    }

    @PostMapping("/add-many")
    fun addManyShields(
        @Valid
        @RequestBody
        newShields: List<NewShield>
    ): List<Shield> {
        try {
            return service.addMultipleShields(newShields)
        } catch (e: Exception) {
            throw ResponseStatusException(BAD_REQUEST, "Shields not added")
        }
    }
}