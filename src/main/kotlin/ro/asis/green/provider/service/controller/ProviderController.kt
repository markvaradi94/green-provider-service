package ro.asis.green.provider.service.controller

import org.springframework.web.bind.annotation.*
import ro.asis.green.provider.service.model.api.dto.ProviderDto
import ro.asis.green.provider.service.model.entity.Address
import ro.asis.green.provider.service.model.entity.GreenBag
import ro.asis.green.provider.service.model.filters.ProviderFilters
import ro.asis.green.provider.service.service.ProviderService

@RestController
@RequestMapping("providers")
class ProviderController(
    private val providerService: ProviderService,
) {
    @GetMapping
    fun getAllProviders(filters: ProviderFilters) = providerService.findAll(filters)

    @GetMapping("{providerId}")
    fun getProvider(@PathVariable providerId: String) = providerService.findProvider(providerId)

    @PostMapping
    fun addProvider(@RequestBody provider: ProviderDto) = providerService.addProvider(provider)

    @PatchMapping("{providerId}")
    fun updateProvider(
        @PathVariable providerId: String,
        @RequestBody provider: ProviderDto
    ) = providerService.patchProvider(providerId, provider)

    @DeleteMapping("{providerId}")
    fun deleteProvider(@PathVariable providerId: String) = providerService.deleteProvider(providerId)

    @GetMapping("{providerId}/inventory")
    fun getProviderInventory(@PathVariable providerId: String) = providerService.getProviderInventory(providerId)

    @DeleteMapping("{providerId}/inventory")
    fun deleteProviderInventory(@PathVariable providerId: String) = providerService.deleteProviderInventory(providerId)

    @PostMapping("{providerId}/inventory")
    fun addGreenBagToInventory(
        @PathVariable providerId: String,
        @RequestBody greenBag: GreenBag
    ) = providerService.addGreenBagToInventory(providerId, greenBag)

    @PatchMapping("{providerId}/inventory/{greenBagId}")
    fun patchProviderGreenBag(
        @PathVariable providerId: String,
        @PathVariable greenBagId: String,
        @RequestBody greenBag: GreenBag
    ) = providerService.patchProviderGreenBag(providerId, greenBagId, greenBag)

    @GetMapping("{providerId}/inventory/{greenBagId}")
    fun getProviderGreenBag(
        @PathVariable providerId: String,
        @PathVariable greenBagId: String
    ) = providerService.getProviderGreenBag(providerId, greenBagId)

    @DeleteMapping("{providerId}/inventory/{greenBagId}")
    fun deleteGreenBagFromInventory(
        @PathVariable providerId: String,
        @PathVariable greenBagId: String
    ) = providerService.deleteGreenBagFromInventory(providerId, greenBagId)

    @GetMapping("{providerId}/address")
    fun getProviderAddress(@PathVariable providerId: String) = providerService.getProviderAddress(providerId)

    @PatchMapping("{providerId}/address")
    fun patchProviderAddress(
        @PathVariable providerId: String,
        @RequestBody address: Address
    ) = providerService.patchProviderAddress(providerId, address)
}