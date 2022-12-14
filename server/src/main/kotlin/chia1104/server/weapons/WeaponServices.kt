package chia1104.server.weapons

import org.springframework.stereotype.Service
import java.util.UUID
import java.util.Optional
import chia1104.server.shared.entities.Weapon
import chia1104.server.shared.dto.weapon.NewWeapon

@Service
class WeaponServices(private val repository: WeaponRepositories) {
    fun getAllWeapons(): List<Weapon> = repository.findAll()

    fun getWeaponById(id: UUID): Optional<Weapon> = repository.findById(id)

    fun createWeapon(newWeapon: NewWeapon): Weapon = repository.save(Weapon.create(newWeapon))

    fun addMultipleWeapons(newWeapons: List<NewWeapon>): List<Weapon> = repository.saveAll(newWeapons.map {
        Weapon.create(it)
    })
}