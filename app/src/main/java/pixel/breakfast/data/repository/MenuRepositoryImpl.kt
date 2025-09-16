package pixel.breakfast.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import pixel.breakfast.data.api.SupabaseApiService
import pixel.breakfast.domain.model.MenuItem
import pixel.breakfast.domain.model.MenuItemMapper
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val api: SupabaseApiService,
    @ApplicationContext private val context: Context,
) : MenuRepository {

    override suspend fun fetchMenu(): Result<List<MenuItem>> = runCatching {
        val res = api.getMenuItems()
        if (!res.isSuccessful) {
            val code = res.code()
            val msg = res.errorBody()?.string().orEmpty()
            throw IllegalStateException("HTTP $code $msg")
        }
        val body = res.body().orEmpty()
        body.map { MenuItemMapper.toDomain(context, it) }
    }
}
