package ro.asis.green.provider.service.model.entity

data class Dashboard(
    //TODO: order microservice needed to get orderIds
    var orderIds: List<String> = listOf()
)