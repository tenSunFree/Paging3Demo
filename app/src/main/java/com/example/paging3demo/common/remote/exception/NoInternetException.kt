package com.example.paging3demo.common.remote.exception

import java.io.IOException

class NoInternetException : IOException() {

    override val message: String?
        get() = "No Internet Connection"
}