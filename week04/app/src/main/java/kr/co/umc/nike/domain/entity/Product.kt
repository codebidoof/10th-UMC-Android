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
    val productName: String,
    val productDescription: String,
    val colorNum: Int,
    val productImage: Int,
    val isWished: Boolean,
    val isBestSeller: Boolean,
    val productPrice: Int
)




