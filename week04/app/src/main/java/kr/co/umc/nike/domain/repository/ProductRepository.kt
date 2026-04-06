package kr.co.umc.nike.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.domain.entity.ProductSummary

interface ProductRepository {

    fun getAllProducts(): Flow<List<ProductSummary>>

    fun getProductsByCategory(categoryId: Int): Flow<List<ProductSummary>>

}
