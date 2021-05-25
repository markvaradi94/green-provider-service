package ro.asis.green.provider.service.repository

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import ro.asis.green.provider.service.model.entity.ProviderEntity
import ro.asis.green.provider.service.model.filters.ProviderFilters
import java.util.Optional.ofNullable

@Repository
class ProviderDao(private val mongo: MongoTemplate) {
    fun findProviders(filters: ProviderFilters): List<ProviderEntity> {
        val query = Query()
        val criteria = buildCriteria(filters)

        if (criteria.isNotEmpty()) query.addCriteria(Criteria().andOperator(*criteria.toTypedArray()))

        return mongo.find(query, ProviderEntity::class.java)
    }

    private fun buildCriteria(filters: ProviderFilters): List<Criteria> {
        val criteria = mutableListOf<Criteria>()

        ofNullable(filters.name).ifPresent { criteria.add(Criteria.where("name").`is`(it)) }
        ofNullable(filters.since).ifPresent { criteria.add(Criteria.where("since").`is`(it)) }

        return criteria
    }
}