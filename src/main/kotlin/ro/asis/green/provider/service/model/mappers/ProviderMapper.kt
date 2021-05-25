package ro.asis.green.provider.service.model.mappers

import org.springframework.stereotype.Component
import ro.asis.green.provider.service.model.api.dto.AddressDto
import ro.asis.green.provider.service.model.api.dto.ProviderDto
import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.ProviderEntity

@Component
class ProviderMapper(
    private val addressMapper: AddressMapper
) : Mapper<ProviderDto, ProviderEntity> {

    override fun toApi(source: ProviderEntity): ProviderDto {
        return ProviderDto(
            id = source.id,
            accountId = source.accountId,
            name = source.name,
            address = addressMapper.toApi(source.address ?: Address()),
            since = source.since,
            description = source.description,
            dashboard = source.dashboard,
            inventory = source.inventory
        )
    }

    override fun toEntity(source: ProviderDto): ProviderEntity {
        return ProviderEntity(
            id = source.id,
            accountId = source.accountId,
            name = source.name,
            address = addressMapper.toEntity(source.address ?: AddressDto()),
            since = source.since,
            description = source.description,
            dashboard = source.dashboard,
            inventory = source.inventory
        )
    }

}
