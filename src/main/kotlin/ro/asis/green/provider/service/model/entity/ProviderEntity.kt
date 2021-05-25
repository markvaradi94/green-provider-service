package ro.asis.green.provider.service.model.entity

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import javax.validation.constraints.NotNull

@Data
@Document(collection = "providers")
class ProviderEntity(
    @Id
    var id: String? = ObjectId.get().toHexString(),

    @NotNull
    val accountId: String?,

    @NotNull
    var name: String?,

    @NotNull
    var since: LocalDate? = LocalDate.now(),

    @NotNull
    var description: String?,

    @NotNull
    var address: Address? = Address(),

    var dashboard: Dashboard? = Dashboard(),

    var inventory: Set<GreenBag>? = setOf()
)
