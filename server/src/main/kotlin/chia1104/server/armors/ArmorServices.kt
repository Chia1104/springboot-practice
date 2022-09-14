package chia1104.server.armors

import chia1104.server.shared.entities.Armor
import org.springframework.stereotype.Service
import java.util.*

@Service
class ArmorServices(private val repository: ArmorRepositories) {
    fun getAllArmors(): List<Armor> = repository.findAll();
    fun getArmorById(id: UUID): Optional<Armor> = repository.findById(id);
    fun createArmor(armor: Armor): Armor = repository.save(armor);
}