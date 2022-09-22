package chia1104.server.headgears

import org.springframework.data.jpa.repository.JpaRepository
import chia1104.server.shared.entities.Headgear
import java.util.UUID
import org.springframework.stereotype.Repository;

@Repository
interface HeadgearRepositories : JpaRepository<Headgear, UUID> {}