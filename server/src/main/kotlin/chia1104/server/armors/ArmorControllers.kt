package chia1104.server.armors

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import chia1104.server.shared.entities.Armor
import chia1104.server.shared.dto.armor.NewArmor
import javax.validation.Valid

@RestController
@RequestMapping("/api/armor")
class ArmorControllers(private val service: ArmorServices) {
    @GetMapping("/all")
    fun getAllArmors(): List<Armor> = service.getAllArmors()

    @GetMapping("/{id}")
    fun getArmorById(@PathVariable id: UUID): Optional<Armor> {
        try {
            return service.getArmorById(id)
        } catch (e: Exception) {
            if (e is NoSuchElementException) {
                throw ResponseStatusException(NOT_FOUND, "Armor not found", e)
            }
            throw ResponseStatusException(INTERNAL_SERVER_ERROR, "Internal server error", e)
        }
    }

    @PostMapping("/add")
    fun addArmor(
        @Valid
        @RequestBody
        armor: NewArmor
    ): Armor {
        try {
            return service.createArmor(armor)
        } catch (e: Exception) {
            if (e is IllegalArgumentException) {
                throw ResponseStatusException(BAD_REQUEST, e.message)
            }
            throw ResponseStatusException(INTERNAL_SERVER_ERROR, e.message)
        }
    }
}