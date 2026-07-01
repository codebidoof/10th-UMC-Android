package kr.co.mky.domain.usecase

import kr.co.mky.domain.repository.ProductRepository

class UpdateWishStatusUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.updateWishStatus(id)
    }
}