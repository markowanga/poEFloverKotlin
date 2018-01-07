package pl.marcinwatroba.efloverkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class EfloverkotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(EfloverkotlinApplication::class.java as Any?, *args)
}
