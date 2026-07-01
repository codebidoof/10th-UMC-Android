package kr.co.mky.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * CategoryTable을 나타내는 Entity 클래스
 * 상품의 카테고리 정보를 저장
 */
@Entity(tableName = "CategoryTable")
data class CategoryEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)
