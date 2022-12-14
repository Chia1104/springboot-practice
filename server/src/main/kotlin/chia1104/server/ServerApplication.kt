package chia1104.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerApplication

fun main(args: Array<String>): Unit {
	runApplication<ServerApplication>(*args)
}
