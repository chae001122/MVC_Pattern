package com.nhn.commerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Service
@EnableJpaAuditing
@SpringBootApplication
class CommerceApplication
fun main(args: Array<String>) {
	runApplication<CommerceApplication>(*args)
}
