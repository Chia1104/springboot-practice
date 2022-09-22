package chia1104.server.headgears

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import javax.validation.Valid
import chia1104.server.shared.entities.Headgear
import chia1104.server.shared.dto.headgear.NewHeadgear

@RestController
@RequestMapping("/api/headgear")
class HeadgearControllers(private val service: HeadgearServices) {
    @GetMapping("/all")
    fun getAllHeadgears(): List<Headgear> = service.getAllHeadgears()

    @GetMapping("/{id}")
    fun getHeadgearById(@PathVariable id: UUID): Optional<Headgear> {
        try {
            return service.getHeadgearById(id)
        } catch (e: Exception) {
            throw ResponseStatusException(NOT_FOUND, "Headgear not found")
        }
    }

    @PostMapping("/add")
    fun addHeadgear(
        @Valid
        @RequestBody
        newHeadgear: NewHeadgear
    ): Headgear {
        try {
            return service.createHeadgear(newHeadgear)
        } catch (e: Exception) {
            throw ResponseStatusException(BAD_REQUEST, "Headgear not added")
        }
    }

    @PostMapping("/add-many")
    fun addManyHeadgears(
        @Valid
        @RequestBody
        newHeadgears: List<NewHeadgear>
    ): List<Headgear> {
        try {
            return service.addMultipleHeadgears(newHeadgears)
        } catch (e: Exception) {
            throw ResponseStatusException(BAD_REQUEST, "Headgears not added")
        }
    }
}