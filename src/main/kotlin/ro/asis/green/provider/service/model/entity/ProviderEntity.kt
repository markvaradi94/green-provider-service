package ro.asis.green.provider.service.model.entity

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Data
@Document(collection = "providers")
class ProviderEntity(
    @Id
    var id: String = ObjectId.get().toHexString(),

    val accountId: String?,

    var name: String?,

    var since: LocalDate?,

    var description: String?,

    var address: Address = Address(),

    var openingHours: MutableSet<OpeningHours>? = mutableSetOf(),

    var dashboard: Dashboard? = Dashboard(),

    var inventory: MutableSet<GreenBag> = mutableSetOf()
)
