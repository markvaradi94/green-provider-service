package ro.asis.green.provider.service.controller

import org.springframework.web.bind.annotation.*
import ro.asis.green.provider.service.exceptions.ProviderNotFoundException
import ro.asis.green.provider.service.model.api.dto.ProviderDto
import ro.asis.green.provider.service.model.filters.ProviderFilters
import ro.asis.green.provider.service.model.mappers.ProviderMapper
import ro.asis.green.provider.service.service.ProviderService

@RestController
@RequestMapping("providers")
class ProviderController(
    private val providerService: ProviderService,
    private val providerMapper: ProviderMapper
) {
    @GetMapping
    fun getAllProviders(filters: ProviderFilters) = providerMapper.toApi(
        providerService.findAll(filters)
    )

    @PostMapping
    fun addProvider(@RequestBody provider: ProviderDto) = providerMapper.toApi(
        providerService.addProvider(providerMapper.toEntity(provider))
    )

    @GetMapping("{providerId}")
    fun getById(@PathVariable providerId: String) = providerMapper.toApi(
        providerService.findById(providerId)
            .orElseThrow { ProviderNotFoundException("Could not find provider") }
    )

    @PutMapping("{providerId}")
    fun updateProvider(
        @PathVariable providerId: String,
        @RequestBody newProvider: ProviderDto
    ) = providerMapper.toApi(
        providerService.updateProvider(providerId, providerMapper.toEntity(newProvider))
    )

    @DeleteMapping("{providerId}")
    fun deleteProvider(@PathVariable providerId: String) = providerMapper.toApi(
        providerService.deleteById(providerId)
    )

}