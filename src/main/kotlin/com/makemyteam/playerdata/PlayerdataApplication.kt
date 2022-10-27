package com.makemyteam.playerdata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories("com.makemyteam.playerdata.repository")
class PlayerdataApplication

fun main(args: Array<String>) {
	runApplication<PlayerdataApplication>(*args)
}
