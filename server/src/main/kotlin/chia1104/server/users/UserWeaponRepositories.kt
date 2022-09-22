package chia1104.server.users

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
import org.springframework.stereotype.Repository
import chia1104.server.shared.entities.UserWeapon

@Repository
interface UserWeaponRepositories : JpaRepository<UserWeapon, UUID> {}