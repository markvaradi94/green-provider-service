package ro.asis.green.provider.service.service

import org.springframework.stereotype.Service
import ro.asis.green.provider.service.exceptions.ProviderNotFoundException
import ro.asis.green.provider.service.model.entity.ProviderEntity
import ro.asis.green.provider.service.model.filters.ProviderFilters
import ro.asis.green.provider.service.repository.ProviderDao
import ro.asis.green.provider.service.repository.ProviderRepository

@Service
class ProviderService(
    private val providerRepository: ProviderRepository,
    private val providerDao: ProviderDao
) {
    fun findAll(filters: ProviderFilters) = providerDao.findProviders(filters)

    fun findById(providerId: String) = providerRepository.findById(providerId)

    fun addProvider(provider: ProviderEntity) = providerRepository.save(provider)

    fun updateProvider(providerId: String, newProvider: ProviderEntity): ProviderEntity {
        val providerToUpdate = getOrThrow(providerId)
        providerToUpdate.name = newProvider.name
        providerToUpdate.address = newProvider.address
        providerToUpdate.since = newProvider.since
        providerToUpdate.description = newProvider.description
        return providerRepository.save(providerToUpdate)
    }

    fun deleteById(providerId: String): ProviderEntity {
        val providerToDelete = getOrThrow(providerId)
        providerRepository.deleteById(providerId)
        return providerToDelete
    }

    private fun getOrThrow(providerId: String) = providerRepository
        .findById(providerId)
        .orElseThrow { ProviderNotFoundException("Could not find provider with id $providerId") }

}
