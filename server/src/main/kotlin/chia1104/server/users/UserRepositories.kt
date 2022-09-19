package chia1104.server.users

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.User
import org.springframework.data.jpa.repository.Query
import java.util.UUID
import org.springframework.stereotype.Repository;

@Repository
interface UserRepositories : JpaRepository<User, UUID> {
    fun findByEmail(email: String): User?
}