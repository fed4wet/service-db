package com.compress.servicedb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceDbApplication

fun main(args: Array<String>) {
	runApplication<ServiceDbApplication>(*args)
}
