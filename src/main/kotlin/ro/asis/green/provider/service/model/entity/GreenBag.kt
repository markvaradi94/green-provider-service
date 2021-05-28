package ro.asis.green.provider.service.model.entity

import org.bson.types.ObjectId

data class GreenBag(
    var id: String = ObjectId.get().toHexString(),
    var description: String? = null,
    var price: Double? = null,
    var imageUrl: String? = null
)
