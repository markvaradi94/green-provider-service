package ro.asis.green.provider.service.service

import org.springframework.stereotype.Service
import ro.asis.green.provider.service.exceptions.ProviderNotFoundException
import ro.asis.green.provider.service.model.api.dto.ProviderDto
import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.GreenBag
import ro.asis.green.provider.service.model.entity.ProviderEntity
import ro.asis.green.provider.service.model.filters.ProviderFilters
import ro.asis.green.provider.service.model.mappers.ProviderMapper
import ro.asis.green.provider.service.repository.ProviderDao
import ro.asis.green.provider.service.repository.ProviderRepository

@Service
class ProviderService(
    private val providerRepository: ProviderRepository,
    private val providerDao: ProviderDao,
    private val providerMapper: ProviderMapper
) {
    fun findAll(filters: ProviderFilters) = providerMapper.toApi(providerDao.findProviders(filters))

    fun findProvider(providerId: String) = providerMapper.toApi(getOrThrow(providerId))

    private fun getOrThrow(providerId: String) = providerRepository
        .findById(providerId)
        .orElseThrow { ProviderNotFoundException("Could not find provider with id $providerId") }

    fun addProvider(provider: ProviderDto) = providerMapper.toApi(
        providerRepository.save(
            providerMapper.toEntity(provider)
        )
    )

    fun patchProvider(providerId: String, newProvider: ProviderDto): ProviderDto {
        val provider = getOrThrow(providerId)
        copyClient(newProvider, provider)
        return providerMapper.toApi(providerRepository.save(provider))
    }

    private fun copyClient(newProvider: ProviderDto, oldProvider: ProviderEntity) {
        oldProvider.name = newProvider.name ?: oldProvider.name
        oldProvider.since = newProvider.since ?: oldProvider.since
        oldProvider.description = newProvider.description ?: oldProvider.description
        oldProvider.openingHours = newProvider.openingHours ?: oldProvider.openingHours
    }

    fun deleteProvider(providerId: String): ProviderDto {
        val providerToDelete = getOrThrow(providerId)
        providerRepository.deleteById(providerId)
        return providerMapper.toApi(providerToDelete)
    }

    fun getProviderInventory(providerId: String): Set<GreenBag> {
        val provider = getOrThrow(providerId)
        return provider.inventory
    }

    fun deleteProviderInventory(providerId: String): ProviderDto {
        val provider = getOrThrow(providerId)
        provider.inventory = mutableSetOf()
        return providerMapper.toApi(providerRepository.save(provider))
    }

    fun addGreenBagToInventory(providerId: String, greenBag: GreenBag): ProviderDto {
        val provider = getOrThrow(providerId)
        provider.inventory.add(greenBag)
        return providerMapper.toApi(providerRepository.save(provider))
    }

    fun patchProviderGreenBag(providerId: String, greenBagId: String, newGreenBag: GreenBag): ProviderDto {
        val provider = getOrThrow(providerId)
        val oldGreenBag = provider.inventory.first { it.id.equals(greenBagId, ignoreCase = false) }
        copyGreenBag(oldGreenBag, newGreenBag)
        return providerMapper.toApi(providerRepository.save(provider))
    }

    private fun copyGreenBag(oldGreenBag: GreenBag, newGreenBag: GreenBag) {
        oldGreenBag.description = newGreenBag.description ?: oldGreenBag.description
        oldGreenBag.price = newGreenBag.price ?: oldGreenBag.price
        oldGreenBag.imageUrl = newGreenBag.imageUrl ?: oldGreenBag.imageUrl
    }

    fun getProviderGreenBag(providerId: String, greenBagId: String): GreenBag {
        val provider = getOrThrow(providerId)
        return provider.inventory.first { it.id.equals(greenBagId, ignoreCase = false) }
    }

    fun deleteGreenBagFromInventory(providerId: String, greenBagId: String): ProviderDto {
        val provider = getOrThrow(providerId)
        provider.inventory.removeIf { it.id.equals(greenBagId, ignoreCase = false) }
        return providerMapper.toApi(providerRepository.save(provider))
    }

    fun getProviderAddress(providerId: String): Address {
        val provider = getOrThrow(providerId)
        return provider.address
    }

    fun patchProviderAddress(providerId: String, newAddress: Address): ProviderDto {
        val provider = getOrThrow(providerId)
        copyAddress(provider.address, newAddress)
        return providerMapper.toApi(providerRepository.save(provider))
    }

    private fun copyAddress(oldAddress: Address, newAddress: Address) {
        oldAddress.city = newAddress.city ?: oldAddress.city
        oldAddress.zipCode = newAddress.zipCode ?: oldAddress.zipCode
        oldAddress.streetName = newAddress.streetName ?: oldAddress.streetName
        oldAddress.streetNumber = newAddress.streetNumber ?: oldAddress.streetNumber
        oldAddress.building = newAddress.building ?: oldAddress.building
        oldAddress.staircase = newAddress.staircase ?: oldAddress.staircase
        oldAddress.floor = newAddress.floor ?: oldAddress.floor
        oldAddress.flat = newAddress.flat ?: oldAddress.flat
    }

}
