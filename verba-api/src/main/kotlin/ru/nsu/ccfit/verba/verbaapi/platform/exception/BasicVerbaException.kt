package ru.nsu.ccfit.verba.verbaapi.platform.exception

import ru.nsu.ccfit.verba.verbaapi.platform.Code


abstract class BasicVerbaException protected constructor(errorCode: Code, message: String) :
    RuntimeException(message) {
    val errorCode: Code

    protected constructor(errorCode: Code) : this(errorCode, errorCode.errorMessage)

    init {
        this.errorCode = errorCode
    }
}
