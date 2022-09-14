package chia1104.server.armors

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import chia1104.server.shared.entities.Armor

@RestController
@RequestMapping("/api/armor")
class ArmorControllers(private val service: ArmorServices) {
    @GetMapping("/all")
    fun getAllArmors(): List<Armor> = service.getAllArmors()

    @GetMapping("/{id}")
    fun getArmorById(@PathVariable id: UUID): Armor = service.getArmorById(id)
        .orElseThrow() { ResponseStatusException(NOT_FOUND, "Armor not found") }

    @PostMapping("/add")
    fun addArmor(@RequestBody armor: Armor): Armor = service.createArmor(armor)
}