package ro.asis.green.provider.service.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ro.asis.green.provider.service.model.entity.ProviderEntity

interface ProviderRepository : MongoRepository<ProviderEntity, String> {
}
