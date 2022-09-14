package chia1104.server.armors

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.Armor
import java.util.UUID

interface ArmorRepositories : JpaRepository<Armor, UUID> {}