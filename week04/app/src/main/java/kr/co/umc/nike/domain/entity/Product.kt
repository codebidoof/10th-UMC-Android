package kr.co.umc.nike.domain.entity

/**
 * 상품 상세 정보 도메인 엔티티
 */
//data class Product(
//    val
//)

/**
 * 상품 간단 정보 도메인 엔티티(목록용)
 */
data class ProductSummary(
    val id: Int,
    val goodImage: Int,
    val isWished: Boolean,
    val isBestSeller: Boolean,
    val goodName: String,
    val goodDescription: String,
    val colorDescription: String,
    val goodPrice: String
)




