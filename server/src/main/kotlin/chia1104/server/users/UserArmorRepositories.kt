package chia1104.server.users

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.UserArmor
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
interface UserArmorRepositories : JpaRepository<UserArmor, UUID> {}