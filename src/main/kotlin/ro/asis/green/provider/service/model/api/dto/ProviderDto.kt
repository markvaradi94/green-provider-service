package ro.asis.green.provider.service.model.api.dto

import org.bson.types.ObjectId
import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.Dashboard
import ro.asis.green.provider.service.model.entity.GreenBag
import ro.asis.green.provider.service.model.entity.OpeningHours
import java.time.LocalDate

data class ProviderDto(
    var id: String = ObjectId.get().toHexString(),
    var accountId: String?,
    var name: String?,
    var since: LocalDate?,
    var description: String?,
    var address: Address? = Address(),
    var openingHours: MutableSet<OpeningHours>?,
    var dashboard: Dashboard? = Dashboard(),
    var inventory: MutableSet<GreenBag>?
)
