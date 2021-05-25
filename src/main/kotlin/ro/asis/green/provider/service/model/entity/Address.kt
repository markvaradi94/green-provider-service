package ro.asis.green.provider.service.model.entity

data class Address(
    var city: String? = null,
    var zipCode: String? = null,
    var streetName: String? = null,
    var streetNumber: String? = null,
    var building: String? = null,
    var staircase: String? = null,
    var floor: Int? = null,
    var flat: String? = null
)
