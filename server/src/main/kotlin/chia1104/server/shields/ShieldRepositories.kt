package chia1104.server.shields

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import org.springframework.stereotype.Repository;
import chia1104.server.shared.entities.Shield

@Repository
interface ShieldRepositories : JpaRepository<Shield, UUID> {}