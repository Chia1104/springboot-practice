package chia1104.server.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

open class HashUtils {
    fun hashPassword(password: String): String {
        val encoder = BCryptPasswordEncoder()
        return encoder.encode(password)
    }

    fun checkPassword(password: String, hash: String): Boolean {
        val encoder = BCryptPasswordEncoder()
        return encoder.matches(password, hash)
    }
}