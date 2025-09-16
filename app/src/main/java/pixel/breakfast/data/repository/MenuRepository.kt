package pixel.breakfast.data.repository

import pixel.breakfast.domain.model.MenuItem

interface MenuRepository {
    suspend fun fetchMenu(): Result<List<MenuItem>>
}
