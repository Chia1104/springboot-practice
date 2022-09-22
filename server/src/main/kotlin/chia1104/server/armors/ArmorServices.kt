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
        Armor(
            name = armor.name,
            description = armor.description,
            image = armor.image,
            defense = armor.defense,
            level = armor.level,
            heaviness = armor.heaviness,
        )
    );
}