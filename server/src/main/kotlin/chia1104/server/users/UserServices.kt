package chia1104.server.users

import chia1104.server.armors.ArmorRepositories
import chia1104.server.headgears.HeadgearRepositories
import chia1104.server.weapons.WeaponRepositories
import chia1104.server.shields.ShieldRepositories
import chia1104.server.shared.dto.user.LoginDto
import chia1104.server.shared.entities.*
import chia1104.server.shared.dto.user.RegisterDto
import org.springframework.stereotype.Service
import chia1104.server.utils.HashUtils
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import java.time.Instant
import java.util.*

@Service
class UserServices(
    private val repository: UserRepositories,
    private val armorRepository: ArmorRepositories,
    private val headgearRepository: HeadgearRepositories,
    private val weaponRepository: WeaponRepositories,
    private val shieldRepository: ShieldRepositories,
    private val userArmorRepository: UserArmorRepositories,
    private val userHeadgearRepository: UserHeadgearRepositories,
    private val userShieldRepository: UserShieldRepositories,
    private val userWeaponRepository: UserWeaponRepositories,
    private val hashUtils: HashUtils,
    private val jwtEncoder: JwtEncoder,
    private val jwtDecoder: JwtDecoder
) {

    fun generateToken(user: User): String {
        val now: Instant = Instant.now()

        val claims = JwtClaimsSet.builder()
            .subject(user.name)
            .claim("id", user.id)
            .claim("email", user.email)
            .claim("name", user.name)
            .claim("roles", user.role)
            .build()

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }

    fun createUser(user: RegisterDto): User {
        if (repository.findByEmail(user.email) != null) {
            throw IllegalArgumentException("Email already exists")
        }
        val hashed = hashUtils.hashPassword(user.password)
        return repository.save(User.create(user.name, user.email, hashed, user.role))
    }

    fun login(user: LoginDto): User {
        val u = repository.findByEmail(user.email) ?: throw IllegalArgumentException("User not found")
        if (!hashUtils.checkPassword(user.password, u.password)) {
            throw IllegalArgumentException("Password is incorrect")
        }
        return u
    }

    fun getUser(id: UUID): User {
        return repository.findById(id).orElseThrow { IllegalArgumentException("User not found") }
    }

    fun getAllUsers(): List<User> {
        return repository.findAll()
    }

    fun updateUserArmor(token: String, armorId: UUID): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        val armor = armorRepository.findById(armorId).orElseThrow { IllegalArgumentException("Armor not found") }
        val updateArmor = userArmorRepository.save(UserArmor.create(
            armor.name,
            armor.description,
            armor.image,
            armor.defense,
            armor.level,
            armor.heaviness,
        ))
        user.armor = updateArmor
        return repository.save(user)
    }

    fun removeUserArmor(token: String): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        user.armor = null
        return repository.save(user)
    }

    fun updateUserHeadgear(token: String, headgearId: UUID): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        val headgear = headgearRepository.findById(headgearId).orElseThrow { IllegalArgumentException("Headgear not found") }
        val updateHeadgear = userHeadgearRepository.save(UserHeadgear.create(
            headgear.name,
            headgear.description,
            headgear.image,
            headgear.defense,
            headgear.level,
            headgear.heaviness,
        ))
        user.headgear = updateHeadgear
        return repository.save(user)
    }

    fun removeUserHeadgear(token: String): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        user.headgear = null
        return repository.save(user)
    }

    fun updateUserWeapon(token: String, weaponId: UUID): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        val weapon = weaponRepository.findById(weaponId).orElseThrow { IllegalArgumentException("Weapon not found") }
        val updateWeapon = userWeaponRepository.save(UserWeapon.create(
            weapon.name,
            weapon.description,
            weapon.image,
            weapon.defense,
            weapon.attack,
            weapon.level,
            weapon.category,
            weapon.heaviness,
        ))
        user.weapon = updateWeapon
        return repository.save(user)
    }

    fun removeUserWeapon(token: String): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        user.weapon = null
        return repository.save(user)
    }

    fun updateUserShield(token: String, shieldId: UUID): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        val shield = shieldRepository.findById(shieldId).orElseThrow { IllegalArgumentException("Shield not found") }
        val updateShield = userShieldRepository.save(UserShield.create(
            shield.name,
            shield.description,
            shield.image,
            shield.defense,
            shield.attack,
            shield.level,
            shield.heaviness,
        ))
        user.shield = updateShield
        return repository.save(user)
    }

    fun removeUserShield(token: String): User {
        val user = repository.findByEmail(this.jwtDecoder.decode(token).getClaimAsString("email")) ?: throw IllegalArgumentException("User not found")
        user.shield = null
        return repository.save(user)
    }
}