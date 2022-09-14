package chia1104.server.users

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.User
import java.util.UUID

interface UserRepositories : JpaRepository<User, UUID> {
    fun findByName(name: String): User?
}