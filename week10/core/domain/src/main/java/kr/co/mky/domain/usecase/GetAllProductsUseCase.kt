package kr.co.mky.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.co.mky.domain.entity.ProductSummary
import kr.co.mky.domain.repository.ProductRepository

class GetAllProductsUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<List<ProductSummary>> {
        return repository.getAllProducts()
    }
}