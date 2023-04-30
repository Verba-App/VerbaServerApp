package ru.nsu.ccfit.verba.verbaapi.platform.exception

import ru.nsu.ccfit.verba.verbaapi.platform.Code


class NotFoundException : BasicVerbaException {
    constructor() : super(Code.NOT_FOUND)
    constructor(message: String) : super(Code.NOT_FOUND, message)
}
