package kr.co.umc.nike.data.data_source.local

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.data.data_source.local.room.table.ProductEntity

interface LocalDataSource {

    fun getAllProducts(): Flow<List<ProductEntity>>

    fun getProductsByCategory(categoryId: Int): Flow<List<ProductEntity>>

}