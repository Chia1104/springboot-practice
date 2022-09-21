package chia1104.server.user_armor

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.UserArmor
import java.util.UUID
import org.springframework.stereotype.Repository;

@Repository
interface UserArmorRepository : JpaRepository<UserArmor, UUID> {}