package kr.co.umc.nike.data.data_source.local

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.data.data_source.local.room.dao.CategoryDao
import kr.co.umc.nike.data.data_source.local.room.dao.ProductDao
import kr.co.umc.nike.data.data_source.local.room.table.ProductEntity
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val productDao: ProductDao,
    private val categoryDao: CategoryDao
) : LocalDataSource {

    override fun getAllProducts(): Flow<List<ProductEntity>> = productDao.getAllProducts()

    override fun getProductsByCategory(categoryId: Int): Flow<List<ProductEntity>> =
        productDao.getProductsByCategory(categoryId)
}