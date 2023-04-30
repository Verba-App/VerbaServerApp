package ru.nsu.ccfit.verba.verbaproxy.filter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import ru.nsu.ccfit.verba.verbaproxy.config.JwtConfig
import ru.nsu.ccfit.verba.verbaproxy.config.RouteValidator

@Component
class AuthenticationFilter(
    @Autowired
    private val validator: RouteValidator,
    @Autowired
    private val jwtConfig: JwtConfig
) :
    AbstractGatewayFilterFactory<AuthenticationFilter.Config>(Config::class.java) {

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val request = exchange.request
            if (validator.isSecured.test(exchange.request)) {
                if (!exchange.request.headers.containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw RuntimeException("missing authorization header")
                }
                var authHeader =
                    exchange.request.headers[HttpHeaders.AUTHORIZATION]!![0]
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7)
                }
                try {
                    val userId = jwtConfig.validateToken(authHeader)
                    request.mutate().header("user-id", userId.toString())
                } catch (e: Exception) {
                    throw RuntimeException("un authorized access to application")
                }
            }
            chain.filter(exchange.mutate().request(request).build())
        }
    }

    class Config
}
