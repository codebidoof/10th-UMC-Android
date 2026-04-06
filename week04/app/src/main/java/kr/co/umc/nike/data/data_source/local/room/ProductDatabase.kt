package kr.co.umc.nike.data.data_source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kr.co.umc.nike.data.data_source.local.room.dao.CategoryDao
import kr.co.umc.nike.data.data_source.local.room.dao.ProductDao
import kr.co.umc.nike.data.data_source.local.room.table.CategoryEntity
import kr.co.umc.nike.data.data_source.local.room.table.ProductEntity

@Database(entities = [ProductEntity::class, CategoryEntity::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "nike_database" // DB 파일 이름
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}