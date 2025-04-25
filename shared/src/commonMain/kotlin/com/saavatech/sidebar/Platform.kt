package com.saavatech.sidebar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform