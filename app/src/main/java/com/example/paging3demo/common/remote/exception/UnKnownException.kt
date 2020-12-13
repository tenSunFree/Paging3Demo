package com.example.paging3demo.common.remote.exception

import java.lang.Exception

class UnKnownException : Exception() {

    override val message: String?
        get() = "Some Unknown Error Occurred"
}