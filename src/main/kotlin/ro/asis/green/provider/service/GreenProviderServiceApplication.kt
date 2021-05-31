package ro.asis.green.provider.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class GreenProviderServiceApplication

fun main(args: Array<String>) {
    runApplication<GreenProviderServiceApplication>(*args)
}
