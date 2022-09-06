package com.anastya.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ToolApplication

fun main(args: Array<String>) {
    runApplication<ToolApplication>(*args)
}

