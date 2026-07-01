package kr.co.umc.nike.data.repositoryimpl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kr.co.umc.nike.data.data_source.local.room.dao.ProductDao
import kr.co.umc.nike.data.mapper.DtoMapper.toDomain
import kr.co.umc.nike.di.Dispatcher
import kr.co.umc.nike.di.NikeDispatchers
import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    @param:Dispatcher(NikeDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : ProductRepository {
    override fun getAllProducts(): Flow<List<ProductSummary>> {
        return productDao.getAllProducts()
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override fun getProductsByWish(isWished: Boolean): Flow<List<ProductSummary>> {
        return productDao.getProductsByWish(isWished)
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override fun getProductsByNew(isNew: Boolean): Flow<List<ProductSummary>> {
        return productDao.getProductsByNew(isNew)
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override fun getProductsByCategory(categoryId: Int): Flow<List<ProductSummary>> {
        return productDao.getProductsByCategory(categoryId)
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override suspend fun updateWishStatus(id: Int) {
        withContext(ioDispatcher) {
            productDao.updateWishStatus(id)
        }
    }

}
