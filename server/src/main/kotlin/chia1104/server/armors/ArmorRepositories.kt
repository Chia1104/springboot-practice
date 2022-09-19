package chia1104.server.armors

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.Armor
import java.util.UUID
import org.springframework.stereotype.Repository;

@Repository
interface ArmorRepositories : JpaRepository<Armor, UUID> {}