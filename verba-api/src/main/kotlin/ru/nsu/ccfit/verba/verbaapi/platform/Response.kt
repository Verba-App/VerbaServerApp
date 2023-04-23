package ru.nsu.ccfit.verba.verbaapi.platform

class Response<T>(
    var code: Code,
    var message: String?,
    var data: T?
) {


    companion object {
        fun <T> withData(data: T): Response<T> {
            return Response(Code.OK, null, data)
        }

        fun <T> withError(code: Code, errorMessage: String?): Response<T> {
            return Response(code, errorMessage, null)
        }

        fun withoutErrors(): Response<Void> {
            return Response(Code.OK, null, null)
        }
    }
}
