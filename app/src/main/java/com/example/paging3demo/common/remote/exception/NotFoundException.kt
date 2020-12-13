package com.example.paging3demo.common.remote.exception

import java.io.IOException

class NotFoundException : IOException() {

    override val message: String?
        get() = "Not Found"
}