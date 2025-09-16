package pixel.breakfast.domain.model

import androidx.annotation.StringRes
import pixel.breakfast.domain.model.enum.MenuCategoryEnum

data class MenuItem(
    val id: String,
    val category: MenuCategoryEnum,
    val displayName : String,
    val price: Int,
    val imageUrl: String?
)