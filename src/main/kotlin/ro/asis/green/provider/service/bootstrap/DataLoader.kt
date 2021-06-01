package ro.asis.green.provider.service.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ro.asis.green.provider.service.model.api.dto.ProviderDto
import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.GreenBag
import ro.asis.green.provider.service.model.entity.OpeningHours
import ro.asis.green.provider.service.service.ProviderService
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

//@Component
//class DataLoader(private val providerService: ProviderService) : CommandLineRunner {
//    override fun run(vararg args: String?) {
//        providerService.addProvider(
//            ProviderDto(
//                id = "",
//                accountId = "123456",
//                name = "KFC",
//                since = LocalDate.now().minusYears(4),
//                description = "Spicy stuffs",
//                address = Address(
//                    city = "Oradea",
//                    zipCode = "31934217",
//                    streetName = "Lotus",
//                    streetNumber = "2",
//                    building = "2",
//                    staircase = "A",
//                    floor = 0,
//                    flat = "1"
//                ),
//                inventory = mutableSetOf(
//                    GreenBag(
//                        description = "Crispy wings",
//                        price = 20.0
//                    ),
//                    GreenBag(
//                        description = "Crispy burger",
//                        price = 60.0
//                    )
//                ),
//                openingHours = mutableSetOf(
//                    OpeningHours(
//                        DayOfWeek.SATURDAY,
//                        LocalTime.of(10, 0),
//                        LocalTime.of(22, 0)
//                    ), OpeningHours(
//                        DayOfWeek.SUNDAY,
//                        LocalTime.of(10, 0),
//                        LocalTime.of(22, 0)
//                    )
//                )
//            )
//        )
//
//        providerService.addProvider(
//            ProviderDto(
//                id = "",
//                accountId = "654321",
//                name = "Pizza hut",
//                since = LocalDate.now().minusYears(4),
//                description = "Pizza 4 life",
//                address = Address(
//                    city = "Oradea",
//                    zipCode = "614852",
//                    streetName = "Lotus Center",
//                    streetNumber = "1",
//                    building = "1",
//                    staircase = "C",
//                    floor = 2,
//                    flat = "4"
//                ),
//                inventory = mutableSetOf(
//                    GreenBag(
//                        description = "Hawaii pizza",
//                        price = 50.9
//                    ),
//                    GreenBag(
//                        description = "Bolognese Pizza",
//                        price = 77.0
//                    )
//                ),
//                openingHours = mutableSetOf(
//                    OpeningHours(
//                        DayOfWeek.THURSDAY,
//                        LocalTime.of(10, 0),
//                        LocalTime.of(24, 0)
//                    ), OpeningHours(
//                        DayOfWeek.FRIDAY,
//                        LocalTime.of(10, 0),
//                        LocalTime.of(24, 0)
//                    )
//                )
//            )
//        )
//    }
//}