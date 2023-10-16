package com.ardikapras.simplepos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonorepoApplication

fun main(args: Array<String>) {
	runApplication<MonorepoApplication>(*args)
}
