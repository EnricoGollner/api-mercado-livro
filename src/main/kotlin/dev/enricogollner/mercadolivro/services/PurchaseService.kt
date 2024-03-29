package dev.enricogollner.mercadolivro.services

import dev.enricogollner.mercadolivro.events.PurchaseEvent
import dev.enricogollner.mercadolivro.models.PurchaseModel
import dev.enricogollner.mercadolivro.repositories.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
        private val purchaseRepository: PurchaseRepository,
        private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel);

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel));
    }
}
