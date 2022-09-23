package chia1104.server.armors

import chia1104.server.shared.entities.Armor
import chia1104.server.shared.dto.armor.NewArmor
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.Optional

@Service
class ArmorServices(private val repository: ArmorRepositories) {
    fun getAllArmors(): List<Armor> = repository.findAll();
    fun getArmorById(id: UUID): Optional<Armor> = repository.findById(id);
    fun createArmor(armor: NewArmor): Armor = repository.save(
        Armor.create(armor)
    );

    fun addMultipleArmors(armors: List<NewArmor>): List<Armor> = repository.saveAll(
        armors.map {
            Armor.create(it)
        }
    );
}