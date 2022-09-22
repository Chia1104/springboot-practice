package chia1104.server.weapons

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid
import chia1104.server.shared.entities.Weapon
import chia1104.server.shared.dto.weapon.NewWeapon

@RestController
@RequestMapping("/api/weapon")
class WeaponControllers(private val service: WeaponServices) {
    @GetMapping("/all")
    fun getAllWeapons(): List<Weapon> = service.getAllWeapons()

    @GetMapping("/{id}")
    fun getWeaponById(@PathVariable id: UUID): Optional<Weapon> {
        try {
            return service.getWeaponById(id)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, "Weapon not found")
        }
    }

    @PostMapping("/add")
    fun addWeapon(
        @Valid
        @RequestBody
        newWeapon: NewWeapon
    ): Weapon {
        try {
            return service.createWeapon(newWeapon)
        } catch (e: Exception) {
            throw ResponseStatusException(BAD_REQUEST, "Weapon not added")
        }
    }
}