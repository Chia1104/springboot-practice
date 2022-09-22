package chia1104.server.shields

import org.springframework.stereotype.Service
import java.util.UUID
import java.util.Optional
import chia1104.server.shared.entities.Shield
import chia1104.server.shared.dto.shield.NewShield

@Service
class ShieldServices (private val repository: ShieldRepository) {
    fun getAllShields(): List<Shield> = repository.findAll()

    fun getShieldById(id: UUID): Optional<Shield> = repository.findById(id)

    fun createShield(newShield: NewShield): Shield {
        val shield = Shield(
            name = newShield.name,
            description = newShield.description,
            image = newShield.image,
            defense = newShield.defense,
            attack = newShield.attack,
            level = newShield.level,
            heaviness = newShield.heaviness,
        )
        return repository.save(shield)
    }
}