package ru.nsu.ccfit.verba.verbaproxy.config

import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import java.util.function.Predicate

@Component
class RouteValidator {
    var isSecured: Predicate<ServerHttpRequest> = Predicate<ServerHttpRequest> { request ->
        openApiEndpoints
            .stream()
            .noneMatch { uri: String ->
                request.uri.path.contains(uri)
            }
    }

    companion object {
        val openApiEndpoints = listOf(
            "/auth/register",
            "/auth/token",
            "/eureka"
        )
    }
}