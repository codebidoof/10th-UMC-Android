package kr.co.umc.nike.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.umc.nike.data.data_source.local.LocalDataSource
import kr.co.umc.nike.data.data_source.local.LocalDataSourceImpl
import kr.co.umc.nike.data.data_source.local.room.dao.CategoryDao
import kr.co.umc.nike.data.data_source.local.room.dao.ProductDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(
        productDao: ProductDao,
        categoryDao: CategoryDao
    ): LocalDataSource {
        return LocalDataSourceImpl(productDao, categoryDao)
    }
}