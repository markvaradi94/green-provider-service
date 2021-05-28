package ro.asis.green.provider.service.model.entity

import java.time.DayOfWeek
import java.time.LocalTime

data class OpeningHours(
    var dayOfWeek: DayOfWeek,
    var openTime: LocalTime,
    var closeTime: LocalTime
)