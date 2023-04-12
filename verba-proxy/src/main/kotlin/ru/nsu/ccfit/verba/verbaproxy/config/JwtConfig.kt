package ru.nsu.ccfit.verba.verbaproxy.config

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key


@Component
class JwtConfig(
    @Value("\${jwt.secret}")
    val secret: String
) {
    fun validateToken(token: String) {
        Jwts.parserBuilder().setSigningKey(signKey).build().parseClaimsJws(token)
    }

    private val signKey: Key
        get() {
            val keyBytes: ByteArray = Decoders.BASE64.decode(secret)
            return Keys.hmacShaKeyFor(keyBytes)
        }
}