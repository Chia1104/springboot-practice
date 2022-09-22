package chia1104.server.weapons

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import org.springframework.stereotype.Repository
import chia1104.server.shared.entities.Weapon

@Repository
interface WeaponRepositories : JpaRepository<Weapon, UUID> {}