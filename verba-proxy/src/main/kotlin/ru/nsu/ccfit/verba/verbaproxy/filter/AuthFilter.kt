package ru.nsu.ccfit.verba.verbaproxy.filter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AuthenticationFilter(
    @Autowired
    private val validator: RouteValidator,
    @Autowired
    private val template: RestTemplate
) :
    AbstractGatewayFilterFactory<AuthenticationFilter.Config>(Config::class.java) {

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            if (validator.isSecured.test(exchange.request)) {
                //header contains token or not
                if (!exchange.request.headers.containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw RuntimeException("missing authorization header")
                }
                var authHeader =
                    exchange.request.headers[HttpHeaders.AUTHORIZATION]!![0]
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7)
                }
                try {
//TODO Не работает запрос
                    val response =
                        template.getForObject("http://VERBA-AUTH//validate?token$authHeader", String::class.java)
                    if (response?.isEmpty() == true) {
                        throw Exception("oy")
                    }
                } catch (e: Exception) {
                    println("invalid access...!")
                    throw RuntimeException("un authorized access to application")
                }
            }
            chain.filter(exchange)
        }
    }

    class Config
}
