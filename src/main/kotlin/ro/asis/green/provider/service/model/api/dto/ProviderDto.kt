package ro.asis.green.provider.service.model.api.dto

import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.Dashboard
import ro.asis.green.provider.service.model.entity.GreenBag
import ro.asis.green.provider.service.model.entity.OpeningHours
import java.time.LocalDate

data class ProviderDto(
    var id: String,
    var accountId: String?,
    var name: String?,
    var since: LocalDate?,
    var description: String?,
    var address: Address?,
    var openingHours: MutableSet<OpeningHours>?,
    var dashboard: Dashboard?,
    var inventory: MutableSet<GreenBag>?
)
