package dev.enricogollner.mercadolivro.events.listenners

import dev.enricogollner.mercadolivro.events.PurchaseEvent
import dev.enricogollner.mercadolivro.services.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(
        private val purchaseService: PurchaseService
) {
    @EventListener
    fun listenPurchaseEvent(purchaseEvent: PurchaseEvent) {
        val nfe = UUID.randomUUID().toString();
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }
}