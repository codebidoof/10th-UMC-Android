package kr.co.mky.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.mky.domain.repository.ProductRepository
import kr.co.mky.domain.usecase.GetAllProductsUseCase
import kr.co.mky.domain.usecase.GetNewProductsUseCase
import kr.co.mky.domain.usecase.GetWishProductsUseCase
import kr.co.mky.domain.usecase.UpdateWishStatusUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllProductsUseCase(
        repository: ProductRepository
    ): GetAllProductsUseCase = GetAllProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetNewProductsUseCase(
        repository: ProductRepository
    ): GetNewProductsUseCase = GetNewProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetWishProductsUseCase(
        repository: ProductRepository
    ): GetWishProductsUseCase = GetWishProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideUpdateWishStateUseCase(
        repository: ProductRepository
    ): UpdateWishStatusUseCase = UpdateWishStatusUseCase(repository)

}