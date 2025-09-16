package pixel.breakfast.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideMenuRepository(
        api: SupabaseApiService,
        @ApplicationContext context: Context,
    ): MenuRepository = MenuRepositoryImpl(api, context)
}
