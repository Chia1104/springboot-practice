package chia1104.server.shields

import org.springframework.stereotype.Service
import java.util.UUID
import java.util.Optional
import chia1104.server.shared.entities.Shield
import chia1104.server.shared.dto.shield.NewShield

@Service
class ShieldServices (private val repository: ShieldRepositories) {
    fun getAllShields(): List<Shield> = repository.findAll()

    fun getShieldById(id: UUID): Optional<Shield> = repository.findById(id)

    fun createShield(newShield: NewShield): Shield {
        val shield = Shield.create(newShield)
        return repository.save(shield)
    }

    fun addMultipleShields(newShields: List<NewShield>): List<Shield> {
        val shields = newShields.map {
            Shield.create(it)
        }
        return repository.saveAll(shields)
    }
}