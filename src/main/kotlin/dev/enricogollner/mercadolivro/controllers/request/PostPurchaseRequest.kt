package dev.enricogollner.mercadolivro.controllers.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class PostPurchaseRequest (
        @field:NotNull
        @field:Positive  // Positive numbers only (>0)
        @JsonAlias("customer_id")
        val customerId: Int,
        @field:NotNull
        @JsonAlias("book_ids")
        val bookIds: Set<Int>,

) {

}
