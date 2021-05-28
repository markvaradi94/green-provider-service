package ro.asis.green.provider.service.model.entity

import org.bson.types.ObjectId

data class Address(
    var _id: String = ObjectId.get().toHexString(),
    var city: String? = null,
    var zipCode: String? = null,
    var streetName: String? = null,
    var streetNumber: String? = null,
    var building: String? = null,
    var staircase: String? = null,
    var floor: Int? = null,
    var flat: String? = null
)
