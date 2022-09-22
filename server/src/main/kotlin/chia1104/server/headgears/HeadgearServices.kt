package chia1104.server.headgears

import chia1104.server.shared.entities.Headgear
import chia1104.server.shared.dto.headgear.NewHeadgear
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.Optional

@Service
class HeadgearServices (private val repository: HeadgearRepositories) {
    fun getAllHeadgears(): List<Headgear> = repository.findAll()

    fun getHeadgearById(id: UUID): Optional<Headgear> = repository.findById(id)

    fun createHeadgear(newHeadgear: NewHeadgear): Headgear {
        val headgear = Headgear(
            name = newHeadgear.name,
            description = newHeadgear.description,
            image = newHeadgear.image,
            defense = newHeadgear.defense,
            level = newHeadgear.level,
            heaviness = newHeadgear.heaviness,
        )
        return repository.save(headgear)
    }

    fun addMultipleHeadgears(newHeadgears: List<NewHeadgear>): List<Headgear> {
        val headgears = newHeadgears.map {
            Headgear(
                name = it.name,
                description = it.description,
                image = it.image,
                defense = it.defense,
                level = it.level,
                heaviness = it.heaviness,
            )
        }
        return repository.saveAll(headgears)
    }
}