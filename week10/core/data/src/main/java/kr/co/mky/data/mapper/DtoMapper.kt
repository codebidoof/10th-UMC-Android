package kr.co.mky.data.mapper

import kr.co.mky.database.entity.ProductEntity
import kr.co.mky.domain.entity.ProductCategory
import kr.co.mky.domain.entity.ProductSummary
import kr.co.mky.domain.entity.Profile
import kr.co.mky.network.model.response.User

/**
 * Data Layer ↔ Domain Layer 변환 Mapper
 */
object DtoMapper {

    // ========== Entity → Domain ==========

    /**
     * ProductEntity → ProductSummary
     */
    fun ProductEntity.toDomain(): ProductSummary {
        return ProductSummary(
            id = id,
            productName = name,
            category = ProductCategory.from(categoryId),
            productDescription = productDescription,
            colorNum = colorNum,
            productImage = productImage,
            isWished = isWished,
            isNew = isNew,
            isBestSeller = isBestSeller,
            productPrice = price
        )
    }

    /**
     * User -> Profile
     */
    fun User.toProfile(): Profile {
        return Profile(
            id = id,
            email = email,
            name = "$firstName $lastName",
            avatar = avatar
        )
    }


}