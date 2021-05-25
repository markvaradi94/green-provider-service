package ro.asis.green.provider.service.model.api.dto

import ro.asis.green.provider.service.model.entity.Dashboard
import ro.asis.green.provider.service.model.entity.GreenBag
import java.time.LocalDate

data class ProviderDto(
    var id: String? = null,
    var accountId: String? = null,
    var name: String? = null,
    var since: LocalDate? = null,
    var description: String? = null,
    var address: AddressDto? = AddressDto(),
    var dashboard: Dashboard? = Dashboard(),
    var inventory: Set<GreenBag>? = setOf()
)
