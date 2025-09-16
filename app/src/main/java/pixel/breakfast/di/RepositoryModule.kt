package pixel.breakfast.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pixel.breakfast.data.api.SupabaseApiService
import pixel.breakfast.data.repository.MenuRepository
import pixel.breakfast.data.repository.MenuRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMenuRepository(api: SupabaseApiService): MenuRepository = MenuRepositoryImpl(api)
}
