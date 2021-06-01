package ro.asis.green.provider.service.model.mappers

import org.springframework.stereotype.Component
import ro.asis.green.provider.service.model.api.dto.ProviderDto
import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.Dashboard
import ro.asis.green.provider.service.model.entity.ProviderEntity

@Component
class ProviderMapper : Mapper<ProviderDto, ProviderEntity> {

    override fun toApi(source: ProviderEntity): ProviderDto {
        return ProviderDto(
            id = source.id,
            accountId = source.accountId,
            name = source.name,
            since = source.since,
            description = source.description,
            address = source.address,
            openingHours = source.openingHours,
            dashboard = source.dashboard,
            inventory = source.inventory
        )
    }

    override fun toEntity(source: ProviderDto): ProviderEntity {
        return ProviderEntity(
            id = source.id,
            accountId = source.accountId,
            name = source.name,
            since = source.since,
            description = source.description,
            address = source.address ?: Address(),
            openingHours = source.openingHours,
            dashboard = source.dashboard ?: Dashboard(),
            inventory = source.inventory ?: mutableSetOf()
        )
    }

}
